# Scalable Applications with Spring Boot and MongoDB

## Overview
This project is a Spring Boot application using MongoDB. It manages users, posts, and comments with CRUD operations. Additional features include updating usernames, fetching posts by author, and adding comments to posts.

## Features
- Create, read, update, and delete users and posts.
- Update a user's username.
- Get all posts by a specific author.
- Add comments to posts.

## Technologies
- Spring Boot
- MongoDB
- Docker
- Nginx (Load Balancer)
- JMeter (Load Testing)

## API Endpoints
### Users
- **POST** `/users` - Create a new user.
- **GET** `/users/{id}` - Get a user by ID.
- **PUT** `/users/updateUser` - Update a user's username.
- **DELETE** `/users/{id}` - Delete a user.

### Posts
- **POST** `/posts` - Create a new post.
- **GET** `/posts/{id}` - Get a post by ID.
- **GET** `/postsByUser/{authorId}` - Get all posts by a specific author.
- **POST** `/posts/{postId}/comments` - Add a comment to a post.

## Setup Instructions
1. **Clone the Project**
    ```bash
    git clone <repository_url>
    ```
2. **Configure MongoDB**
    Update `application.properties` with MongoDB settings.
3. **Build and Run the Application**
    ```bash
    mvn clean install
    ```

## Docker Setup
1. **Start with Docker**
    ```bash
    docker-compose up
    ```
2. **Services Running**
    - MongoDB
    - Mongo Express for UI Management
    - Two Spring Boot Instances
    - Nginx for Load Balancing

## Load Testing
- Perform testing using **JMeter**.
- Use the `.jmx` test plan

