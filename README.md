# PERSONAL_SITE - Backend

## Installation

### Prerequisites
 - java
 - spring-boot
 - gradle
 - postgres

### Clone
 - Clone this repo to your machine using `git clone git@github.com:Ajris/site_backend.git`
 
### Setup
 - `gradle build`

## Tests
 - `gradle test`

## Current Flow
1. Task from Trello
3. Commits & Work
4. Pull Request
5. TravisCI
6. Build
7. Testing
8. Building docker image and deploying to DockerHub
9. Checking with SonarCloud
10. After everything passed successfully(6,7,8,9) merge is possible
11. Merge

## Available commands

In project directory:

### `gradle bootRun`
App is running on http://localhost:8080