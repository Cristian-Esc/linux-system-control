📝 **README**

# Linux System Control 🐧💻

Linux System Control is a web-based management tool developed with Java 17 and the Spring Framework, using Gradle as the build tool. It allows you to control various functions of a Linux system remotely through a user-friendly web interface. 🌐✨

## Features

The Linux System Control tool provides the following features:

🔌 **System Power Management**: Suspend or hibernate the computer remotely with just a few clicks.

📸 **Screenshot Capture**: Capture screenshots of the Linux desktop from any connected device.

🔊 **Volume Control**: Adjust the system volume or mute/unmute the audio remotely.

📷 **Webcam Photo Capture**: Take photos using the webcam connected to the Linux system.

... and more features to come!

## Prerequisites

Before running the Linux System Control tool, ensure you have the following:

- Java Development Kit (JDK) 17 or later installed on the server.
- Gradle build tool for Java.
- A web browser to access the web-based interface.

## Installation

1. Clone this repository to your local machine or server.
2. Navigate to the project directory and compile the code using Gradle: `gradle build`.
3. Run the application using the command: `java -jar build/libs/linux-system-control.jar`.
4. Open a web browser and access the application at `http://localhost:8080` or the appropriate server address.

## Configuration

To customize the Linux System Control tool, you can modify the configuration files:

- `application.properties`: Configure the server port, database connection, and other application properties.
- Add additional functionalities by extending the existing controllers and services.

## Contributing

Contributions to enhance the functionality or fix issues are welcome! Please feel free to open a pull request with your changes.

## Contact

For any questions or feedback, please reach out to Cristian Escobedo at escobedo@esserdi.com.

## License

This project is licensed under the [MIT License](LICENSE).

---

Enjoy managing your Linux system effortlessly with Linux System Control! 🚀🖥️
