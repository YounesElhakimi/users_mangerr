# User Management Microservice

A comprehensive user management microservice built with Spring Boot 3.2.x, featuring JWT-based authentication, role-based access control, and robust security features.

## Features

- User registration and authentication
- JWT-based authentication with refresh tokens
- Role-based access control (RBAC)
- Password management with history
- Profile management
- Admin dashboard
- Rate limiting
- Comprehensive API documentation
- Health monitoring and metrics

## Prerequisites

- Java 17 or higher
- Maven 3.9+
- PostgreSQL 15+
- Redis (optional, for session management and rate limiting)

## Quick Start

1. Clone the repository:
```bash
git clone https://github.com/yourusername/user-management-service.git
cd user-management-service
```

2. Configure the database:
- Create a PostgreSQL database named `user_management`
- Update `application.yml` with your database credentials

3. Build the project:
```bash
mvn clean install
```

4. Run the application:
```bash
mvn spring-boot:run
```

The service will start on port 8080 by default. Access the Swagger UI at `http://localhost:8080/api/v1/swagger-ui.html`

## Environment Variables

| Variable | Description | Default |
|----------|-------------|---------|
| DB_USERNAME | PostgreSQL username | postgres |
| DB_PASSWORD | PostgreSQL password | postgres |
| REDIS_HOST | Redis host | localhost |
| REDIS_PORT | Redis port | 6379 |
| JWT_SECRET | JWT signing key | your-256-bit-secret-key-here |
| SERVER_PORT | Application port | 8080 |

## API Documentation

The API documentation is available through Swagger UI at `/api/v1/swagger-ui.html` when the application is running.

### Main Endpoints

- Authentication:
  - POST `/api/v1/auth/register` - Register new user
  - POST `/api/v1/auth/login` - User login
  - POST `/api/v1/auth/refresh` - Refresh access token
  - POST `/api/v1/auth/logout` - Logout user

- User Management:
  - GET `/api/v1/users/profile` - Get user profile
  - PUT `/api/v1/users/profile` - Update user profile
  - POST `/api/v1/users/change-password` - Change password
  - POST `/api/v1/users/forgot-password` - Request password reset
  - POST `/api/v1/users/reset-password` - Reset password

- Admin Endpoints:
  - GET `/api/v1/admin/users` - List all users
  - GET `/api/v1/admin/users/{userId}` - Get user details
  - PUT `/api/v1/admin/users/{userId}/status` - Update user status
  - POST `/api/v1/admin/users/{userId}/roles` - Assign roles
  - DELETE `/api/v1/admin/users/{userId}/roles/{roleId}` - Remove role

## Security Features

- JWT-based authentication
- Password encryption using BCrypt
- Role-based access control
- Rate limiting
- CORS configuration
- Security headers
- Input validation
- SQL injection prevention
- XSS protection

## Monitoring

The service includes several monitoring endpoints:

- Health check: `/api/v1/actuator/health`
- Metrics: `/api/v1/actuator/metrics`
- Prometheus metrics: `/api/v1/actuator/prometheus`

## Development

### Project Structure

```
src/main/java/com/example/usermanagement/
├── config/          # Configuration classes
├── controller/      # REST controllers
├── dto/            # Data transfer objects
├── entity/         # JPA entities
├── exception/      # Custom exceptions
├── repository/     # JPA repositories
├── security/       # Security configuration
├── service/        # Business logic
└── util/           # Utility classes
```

### Running Tests

```bash
mvn test
```

## Contributing

1. Fork the repository
2. Create your feature branch (`git checkout -b feature/amazing-feature`)
3. Commit your changes (`git commit -m 'Add some amazing feature'`)
4. Push to the branch (`git push origin feature/amazing-feature`)
5. Open a Pull Request

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details. 