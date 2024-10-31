
FROM oven/bun:1-slim AS base
WORKDIR /usr/src/app

ENV NODE_ENV=production

FROM base AS dependencies
WORKDIR /usr/src/app
COPY package.json bun.lockb ./
RUN bun install --frozen-lockfile --production

FROM base AS release
WORKDIR /usr/src/app

COPY --from=dependencies /usr/src/app/node_modules ./node_modules
COPY . .

USER bun 

EXPOSE 5000/tcp

ENTRYPOINT ["bun", "run", "index.js"]
