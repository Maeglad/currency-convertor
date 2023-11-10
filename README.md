# Currency Conversion Spring Boot Application

This Spring Boot application provides currency conversion functionality, allowing users to retrieve a list of currency conversion rates and convert between currencies.

## Technologies Used

- Spring Boot
- Spring Data JPA
- Spring REST API
- H2 In-Memory Database
- Mockito for Testing

## Endpoints

### Get Currency Conversions

- **Endpoint:** `GET /api/conversions`
- **Description:** Retrieves a list of currency conversions stored in the local database.

### Convert Between Currencies

- **Endpoint:** `POST /api/convert`
- **Description:** Converts between currencies based on the provided parameters.
