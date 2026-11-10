# Agriculture Farm Management System

## Requirements
- Java 21
- Maven
- MySQL 8
- Eclipse or IntelliJ
- Postman

## Setup
1. Create database: `CREATE DATABASE agri_management;`
2. Open `src/main/resources/application.properties` and replace `CHANGE_ME` with your local MySQL password.
3. Import this folder as an Existing Maven Project.
4. Run `AgriManagementSystemApplication`.
5. Test APIs at `http://localhost:8080`.

## API endpoints
- `/api/farmers`
- `/api/farms`
- `/api/fields`
- `/api/crops`
- `/api/crop-plans`
- `/api/activities`
- `/api/expenses`
- `/api/harvests`

All resources support POST, GET collection, GET by id, PUT by id, DELETE by id.
Use `GET /api/farms` etc. For create/update, send JSON matching the corresponding `*Request` DTO.

## Important implementation notes
- This is a backend starter implementation. Review and test each module before using real farm data.
- Entity relationships use LAZY many-to-one associations and ignore inverse collections in JSON to avoid recursion.
- Add production-grade DTO response mapping, pagination, audit fields, authorization, and database migrations before deployment.
- `ddl-auto=update` is suitable for local development only; use Flyway/Liquibase and validated migrations for production.
- Do not commit database passwords to Git.
