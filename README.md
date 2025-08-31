# Serverless URL Shortener

This project is a **serverless URL shortener** built with **Spring Boot** and integrated with **AWS DynamoDB**.

## 🚀 Features
- Shorten long URLs into unique short links.
- Scalable storage using **DynamoDB**.
- Automatic cleanup of expired links after 7 days.
- **Serverless** and **cloud-ready** architecture.

## 🛠️ Tech Stack
- Java + Spring Boot
- AWS DynamoDB (Enhanced Client)
- Lombok
- Scheduler for automated tasks

## Project Structure
- `service/` → Core services (e.g., `CleanupService` for expired token removal)
- `model/` → Model classes (e.g., `UrlMapping`)
- `controller/` → REST API endpoints
- `config/` → Project configuration

## How to Run
1. Clone the repository:
   ```bash
   git clone https://github.com/your-username/serverless-url-shortener.git
   cd serverless-url-shortener
   ```

2. Configure AWS credentials and the table name in `application.yml`:
   ```yaml
   dynamodb:
     tableName: url_shortener
   ```

3. Build and run the project:
   ```bash
   ./mvnw spring-boot:run
   ```

## 📌 Scheduled Cleanup
- A **daily scheduled job** removes entries older than **7 days** from DynamoDB.

## License
This project is licensed under the MIT License. See the [LICENSE](LICENSE) file for details.
