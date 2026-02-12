# Access-Request-Approval-Automation-Platform
The Access Request Approval Automation Platform streamlines access request workflows such as VPN, database, and tool access approvals. 
It replaces manual email-based processes with a secure, auditable system that logs every action and reduces approval time.

## Tech Stack
- **Backend:** Spring Boot, Java
- **Database:** MySQL/PostgreSQL
- **Frontend:** JSP/HTML/CSS/JS
- **Others:** Maven, Git, REST APIs

## API Endpoints
| Endpoint             | Method | Auth | Description            |
| -------------------- | ------ | ---- | ---------------------- |
| /                    | GET    | Basic Auth admin@example.com/password123 | Welcome / Health Check |
| /api/auth/signup     | POST   | None | User Registration      |
| /api/auth/login      | POST   | None | User Login             |
| /api/admin/dashboard | GET    | None | Admin Dashboard        |
| /api/user/profile    | GET    | None | User Profile           |
