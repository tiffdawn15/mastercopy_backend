# mastercopy_backend

## Overview

`mastercopy_backend` is a Spring Boot REST API that powers the Mastercopy frontend. It provides secure user authentication via Auth0 and endpoints for managing user accounts and collections.

## Features

Implements Auth0 authentication for secure user management.
Provides RESTful APIs for managing user accounts and collections.
Serves as the backend for the Mastercopy frontend application.

## Authentication

This backend uses Auth0 for user authentication. All protected endpoints require a valid Auth0 JWT token.
To access these endpoints, users must log in through Auth0 and include the JWT token in the `Authorization` header of their requests.

## Collections API
Endpoints allow users to create, read, update, and delete collections associated with their accounts.

## Getting Started

### Prerequisites

- Java 17+ (or your project's required version)
- Gradle
- MongoDB instance
- Auth0 account and application

### Setup

1. **Clone the repository:**
   ```sh
   git clone git@github.com:tiffdawn15/mastercopy_backend.git
   cd mastercopy_backend
   ``` 
   
2. Configure env vars: 
   Create a `.env` file in the root directory with the following variables:
   ```env
   AUTH0_DOMAIN=your-auth0-domain
   AUTH0_CLIENT_ID=your-auth0-client-id
   MONGODB_URI=mongodb://localhost:27017/your-database-name
   ```
   
3. **Build the project:**
   ```sh
   ./gradlew build
   ```

## Contact
For questions or support, open an issue or contact @tiffdawn15