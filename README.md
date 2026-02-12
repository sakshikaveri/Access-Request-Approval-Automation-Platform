# Access-Request-Approval-Automation-Platform
The **Access Request Approval Automation Platform** is a backend-only Spring Boot application that automates access request approvals, such as VPN, database, and tool access.  
It replaces manual email-based workflows with a **secure, auditable, and API-driven system**.

> ⚠️ **Note:** This project does **not include a frontend**. Interact with the APIs using **Postman, curl, or any API client**.


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
