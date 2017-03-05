# jhazelnut-csms
JHazelnut Cloud Storage Manager Service

# Build the project
    gradle clean build

# Run Spring Boot
After building the project a executable must have been generated.
Run it using:
    java -jar /build/libs/jhazelnut-csms-0.1.0.jar

# Angular 2 Front End
If making changes to the Front-End in angular2FrontEnd/src/
Then you need to recompile everythin using angular-cli
Inside angular2FrontEnd directory run
    ng build

If for some f#ck1ng reason ng needs root privileges then remember to give
permissions to /src/main/resources/public or instead of running ng build do
    sh compileFrontEnd.sh