# Creating a Database Connection
- Create a class to serve a connection between the postgres database and the server
- this class will hold a connection to the postgres database
- it will have a method to call an SQL query with the postgres connection
- it will have a method to create SQL queries through string interpolation
	- we only have one endpoint `get` 
	- so that means the `sql` query will be built from the user query
- it will parse through the `sql` query's output and return it

## Schema
- so the way that *I* would build this would be the following
- `class Database`
	- `constructor` imports env variables for database connection & creates an instance of the database connection
	- `makeQuery` takes in 3 variables - returns a prepared SQL query
		`name`
		`team`
		`cohort`
	- `executeQuery` takes in a SQL query and returns to you the result

### SQL Example We Use Right Now
```typescript
router.get("/get", async (req: any, res: any) => {
    let baseQuery = "SELECT * FROM projects";
    const filters: string[] = [];
    const values: (string | number)[] = [];

    // if the name filter was provided
    if (req.query.name) {
        filters.push(`name ILIKE $${filters.length + 1}`);
        values.push(`%${req.query.name}%`);
    }

    // if the cohort filter was provided
    if (req.query.cohort) {
        filters.push(`cohort ILIKE $${filters.length + 1}`);
        values.push(`%${req.query.cohort}%`);
    }
    // if the team filter was provided
    if (req.query.team) {
        filters.push(`team ILIKE $${filters.length + 1}`);
        values.push(`%${req.query.team}%`);
    }

    // combine all the filters into a single query
    if (filters.length > 0) {
        baseQuery += " WHERE " + filters.join(" AND ");
    }

    // execute the query, making sure to provide the values for the filters
    try {
        const data: QueryResult = await queryDatabase(
            req.client,
            baseQuery,
            values,
        );
        return res.status(200).send(data.rows);
    } catch (error: any) {
        return res
            .status(500)
            .json({ message: `Error retrieving data. ${error.toString()}` });
    }
});
```