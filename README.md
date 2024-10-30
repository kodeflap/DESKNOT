# DESKNOT: Android To-Do List Application

**DESKNOT** is a task management application designed to simplify and organize your daily activities. It provides a sleek and user-friendly interface for managing tasks with priority levels, undo actions, and seamless data persistence. Built with modern Android development practices, DESKNOT ensures a smooth experience for users and a robust foundation for developers.

---

## Table of Contents
- [Features](#features)
- [Tech Stack](#tech-stack)
- [Architecture](#architecture)
- [Demo](#demo)
- [Installation](#installation)
- [Usage](#usage)
- [Contributing](#contributing)
- [License](#license)

---

## Features

- **Complete Task Management**:
  - Create, view, update, and delete tasks effortlessly.
  - Task search and sorting for quick organization.
  - Undo functionality to restore mistakenly deleted tasks.
  
- **Task Prioritization**:
  - **Red**: High priority
  - **Yellow**: Medium priority
  - **Green**: Low priority

- **Persistence with Room Database**: Retains tasks across app restarts with a structured database.

- **Enhanced UI/UX**:
  - Interactive task list displayed using `RecyclerView`.
  - Animations for floating action buttons and navigation elements.
  
- **Modern Architecture with MVVM**:
  - **LiveData** updates for real-time task management.
  - `ViewModel` for managing UI-related data and business logic.

- **Asynchronous Operations with Coroutines**: Ensures a smooth, non-blocking user experience.

- **Binding Libraries**:
  - `ViewBinding` and `DataBinding` for safe and efficient UI interactions.

---

## Tech Stack
- **Language**: Kotlin
- **Database**: Room
- **Architecture**: MVVM (Model-View-ViewModel)
- **Concurrency**: Coroutines
- **UI Components**: RecyclerView, ViewBinding, DataBinding
- **Animations**: Floating buttons, navigation transitions

---

## Architecture
The project follows the MVVM (Model-View-ViewModel) architecture, which promotes separation of concerns and enhances scalability and maintainability:

- **Model**: Contains the app's data and business logic, using a repository for task storage with Room database.
- **ViewModel**: Manages the UI-related data, updating views through LiveData and handling asynchronous operations with Coroutines.
- **View**: Composed of UI elements that observe LiveData changes and reflect updates in real-time.

---

## Demo
Here’s a walkthrough of the app in action:

![Demo GIF](https://github.com/kodeflap/DESKNOT/raw/master/VID_20241030095815%20(2).gif)

---

## Installation

1. **Clone the Repository**:
   ```bash
   git clone https://github.com/kodeflap/DESKNOT.git
   ```
2. **Open in Android Studio**: Import the project into Android Studio.
3. **Build the Project**: Sync Gradle files and build the project.
4. **Run the App**: Install and run on an emulator or physical device.

---

## Usage

- **Add a Task**: Tap the floating action button to create a new task, set priority, and save.
- **View & Manage Tasks**: All tasks appear in the main list, prioritized by color.
- **Edit or Update**: Tap a task to modify its details.
- **Delete & Undo**: Swipe to delete; use the undo option to restore if needed.
- **Search & Sort**: Use the search bar to filter tasks or sort by priority.

---

## Contributing
Contributions, issues, and feature requests are welcome! Feel free to check the [issues page](https://github.com/kodeflap/DESKNOT/issues) to report bugs or suggest improvements.

1. Fork the project.
2. Create a feature branch (`git checkout -b feature/YourFeature`).
3. Commit changes (`git commit -m 'Add your feature'`).
4. Push to the branch (`git push origin feature/YourFeature`).
5. Open a Pull Request.

---

## License
This project is licensed under the MIT License. See the [LICENSE](LICENSE) file for details.

---

