FROM oven/bun:latest AS base
WORKDIR /app

FROM base AS dependencies
WORKDIR /app
COPY package.json bun.lockb ./
RUN bun install --frozen-lockfile --production

FROM base AS release
WORKDIR /app
COPY --from=dependencies /app/node_modules ./node_modules
COPY . .

USER bun
EXPOSE 5000/tcp
ENTRYPOINT [ "bun", "run", "index.js" ]
