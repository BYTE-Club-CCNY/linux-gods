# Calling the bun base, using -slim to reduce build size, by only calling the bare minimum libraries
FROM oven/bun:1-slim AS base
WORKDIR /usr/src/app

# Copying dependencies
FROM base AS dependencies
WORKDIR /usr/src/app
COPY package.json bun.lockb ./
# --production calls the dependencies needed during production only(Skipping dev dependencies), which keeps the image light weight.
RUN bun install --frozen-lockfile --production 

# Release stage
FROM base AS release
WORKDIR /usr/src/app
COPY --from=dependencies /usr/src/app/node_modules ./node_modules
COPY . .
# Avoiding root permissions, reduces attack surface.
EXPOSE 5000/tcp
ENTRYPOINT ["bun", "run", "index.js"]
