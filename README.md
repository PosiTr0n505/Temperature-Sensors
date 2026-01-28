# README - Application de Station Météo JavaFX

Ce projet a été réalisé dans le cadre de plusieurs Travaux Pratiques (TP) universitaires portant sur l'apprentissage des patrons de conception (Design Patterns) et le développement d'interfaces graphiques avec JavaFX.

## Description
L'application simule un système de gestion de capteurs météorologiques. Elle permet de créer des capteurs individuels (physiques) basés sur différents algorithmes de génération de température, ainsi que des capteurs virtuels calculant des moyennes pondérées à partir d'autres capteurs.

## Patrons de Conception (Design Patterns)
Ce projet met en œuvre plusieurs concepts clés de la programmation orientée objet :
* **Observer** : Utilisé pour notifier les changements de température. Les capteurs (Sujets) notifient les observateurs, tels que les capteurs virtuels ou les composants de l'interface, dès qu'une nouvelle valeur est générée.
* **Strategy** : Utilisé pour la génération de température. La classe `Sensor` utilise une instance de `TemperatureGenerator`, permettant de basculer entre différentes stratégies de calcul comme le générateur réaliste ou aléatoire.
* **MVC (Modèle-Vue-Contrôleur)** : Séparation entre la logique métier (`Models`), l'interface utilisateur (`MainPage.fxml`) et la logique de contrôle (`WeatherController`).

## Fonctionnalités
* Création de capteurs simples avec choix du générateur (Réaliste ou Aléatoire).
* Création de capteurs virtuels.
* Agrégation de capteurs : ajout ou suppression de capteurs contributeurs à un capteur virtuel avec gestion d'un coefficient de pondération.
* Mise à jour en temps réel de l'affichage via des threads dédiés pour chaque capteur.
* Suppression de capteurs existants.# README - Application de Station Météo JavaFX

Ce projet a été réalisé dans le cadre de plusieurs Travaux Pratiques (TP) universitaires portant sur l'apprentissage des patrons de conception (Design Patterns) et le développement d'interfaces graphiques avec JavaFX.

## Description
L'application simule un système de gestion de capteurs météorologiques. Elle permet de créer des capteurs individuels (physiques) basés sur différents algorithmes de génération de température, ainsi que des capteurs virtuels calculant des moyennes pondérées à partir d'autres capteurs.

## Patrons de Conception (Design Patterns)
Ce projet met en œuvre plusieurs concepts clés de la programmation orientée objet :
* **Observer** : Utilisé pour notifier les changements de température. Les capteurs (Sujets) notifient les observateurs, tels que les capteurs virtuels ou les composants de l'interface, dès qu'une nouvelle valeur est générée.
* **Strategy** : Utilisé pour la génération de température. La classe `Sensor` utilise une instance de `TemperatureGenerator`, permettant de basculer entre différentes stratégies de calcul comme le générateur réaliste ou aléatoire.
* **MVC (Modèle-Vue-Contrôleur)** : Séparation entre la logique métier (`Models`), l'interface utilisateur (`MainPage.fxml`) et la logique de contrôle (`WeatherController`).

## Fonctionnalités
* Création de capteurs simples avec choix du générateur (Réaliste ou Aléatoire).
* Création de capteurs virtuels.
* Agrégation de capteurs : ajout ou suppression de capteurs contributeurs à un capteur virtuel avec gestion d'un coefficient de pondération.
* Mise à jour en temps réel de l'affichage via des threads dédiés pour chaque capteur.
* Suppression de capteurs existants.

## Structure du Projet
* `Models` : Contient la logique des capteurs et les classes de base du patron Observer.
* `Generators` : Contient les différentes stratégies de génération de données.
* `WeatherApp` : Contient le point d'entrée de l'application et les contrôleurs JavaFX.
* `resources` : Fichiers FXML définissant l'interface utilisateur.

## Diagramme UML
(Emplacement pour le diagramme UML)

---

# README - JavaFX Weather Station Application

This project was developed during several university lab sessions (TPs) focused on Design Patterns and GUI development using JavaFX.

## Description
The application simulates a weather sensor management system. It allows the creation of individual (physical) sensors based on different temperature generation algorithms, as well as virtual sensors that calculate weighted averages from other sensors.

## Design Patterns
This project implements several key object-oriented concepts:
* **Observer**: Used for temperature change notifications. Sensors (Subjects) notify observers, such as virtual sensors or UI components, as soon as a new value is generated.
* **Strategy**: Used for temperature generation. The `Sensor` class utilizes a `TemperatureGenerator` instance, allowing a switch between different calculation strategies like realistic or random generation.
* **MVC (Model-View-Controller)**: Separation between business logic (`Models`), the user interface (`MainPage.fxml`), and the control logic (`WeatherController`).

## Features
* Creation of simple sensors with a choice of generator (Realistic or Random).
* Creation of virtual sensors.
* Sensor aggregation: add or remove contributing sensors to a virtual sensor with weight coefficient management.
* Real-time display updates via dedicated threads for each sensor.
* Deletion of existing sensors.

## Project Structure
* `Models`: Contains sensor logic and the base classes for the Observer pattern.
* `Generators`: Contains the various data generation strategies.
* `WeatherApp`: Contains the application entry point and JavaFX controllers.
* `resources`: FXML files defining the user interface.

## UML Diagram
(Placeholder for the UML diagram)# README - Application de Station Météo JavaFX

Ce projet a été réalisé dans le cadre de plusieurs Travaux Pratiques (TP) universitaires portant sur l'apprentissage des patrons de conception (Design Patterns) et le développement d'interfaces graphiques avec JavaFX.

## Description
L'application simule un système de gestion de capteurs météorologiques. Elle permet de créer des capteurs individuels (physiques) basés sur différents algorithmes de génération de température, ainsi que des capteurs virtuels calculant des moyennes pondérées à partir d'autres capteurs.

## Patrons de Conception (Design Patterns)
Ce projet met en œuvre plusieurs concepts clés de la programmation orientée objet :
* **Observer** : Utilisé pour notifier les changements de température. Les capteurs (Sujets) notifient les observateurs, tels que les capteurs virtuels ou les composants de l'interface, dès qu'une nouvelle valeur est générée.
* **Strategy** : Utilisé pour la génération de température. La classe `Sensor` utilise une instance de `TemperatureGenerator`, permettant de basculer entre différentes stratégies de calcul comme le générateur réaliste ou aléatoire.
* **MVC (Modèle-Vue-Contrôleur)** : Séparation entre la logique métier (`Models`), l'interface utilisateur (`MainPage.fxml`) et la logique de contrôle (`WeatherController`).

## Fonctionnalités
* Création de capteurs simples avec choix du générateur (Réaliste ou Aléatoire).
* Création de capteurs virtuels.
* Agrégation de capteurs : ajout ou suppression de capteurs contributeurs à un capteur virtuel avec gestion d'un coefficient de pondération.
* Mise à jour en temps réel de l'affichage via des threads dédiés pour chaque capteur.
* Suppression de capteurs existants.

## Structure du Projet
* `Models` : Contient la logique des capteurs et les classes de base du patron Observer.
* `Generators` : Contient les différentes stratégies de génération de données.
* `WeatherApp` : Contient le point d'entrée de l'application et les contrôleurs JavaFX.
* `resources` : Fichiers FXML définissant l'interface utilisateur.

## Diagramme UML
(Emplacement pour le diagramme UML)

---

# README - JavaFX Weather Station Application

This project was developed during several university lab sessions (TPs) focused on Design Patterns and GUI development using JavaFX.

## Description
The application simulates a weather sensor management system. It allows the creation of individual (physical) sensors based on different temperature generation algorithms, as well as virtual sensors that calculate weighted averages from other sensors.

## Design Patterns
This project implements several key object-oriented concepts:
* **Observer**: Used for temperature change notifications. Sensors (Subjects) notify observers, such as virtual sensors or UI components, as soon as a new value is generated.
* **Strategy**: Used for temperature generation. The `Sensor` class utilizes a `TemperatureGenerator` instance, allowing a switch between different calculation strategies like realistic or random generation.
* **MVC (Model-View-Controller)**: Separation between business logic (`Models`), the user interface (`MainPage.fxml`), and the control logic (`WeatherController`).

## Features
* Creation of simple sensors with a choice of generator (Realistic or Random).
* Creation of virtual sensors.
* Sensor aggregation: add or remove contributing sensors to a virtual sensor with weight coefficient management.
* Real-time display updates via dedicated threads for each sensor.
* Deletion of existing sensors.

## Project Structure
* `Models`: Contains sensor logic and the base classes for the Observer pattern.
* `Generators`: Contains the various data generation strategies.
* `WeatherApp`: Contains the application entry point and JavaFX controllers.
* `resources`: FXML files defining the user interface.

## UML Diagram
(Placeholder for the UML diagram)

## Structure du Projet
* `Models` : Contient la logique des capteurs et les classes de base du patron Observer.
* `Generators` : Contient les différentes stratégies de génération de données.
* `WeatherApp` : Contient le point d'entrée de l'application et les contrôleurs JavaFX.
* `resources` : Fichiers FXML définissant l'interface utilisateur.

## Diagramme UML


---

# README - JavaFX Weather Station Application

This project was developed during several university lab sessions (TPs) focused on Design Patterns and GUI development using JavaFX.

## Description
The application simulates a weather sensor management system. It allows the creation of individual (physical) sensors based on different temperature generation algorithms, as well as virtual sensors that calculate weighted averages from other sensors.

## Design Patterns
This project implements several key object-oriented concepts:
* **Observer**: Used for temperature change notifications. Sensors (Subjects) notify observers, such as virtual sensors or UI components, as soon as a new value is generated.
* **Strategy**: Used for temperature generation. The `Sensor` class utilizes a `TemperatureGenerator` instance, allowing a switch between different calculation strategies like realistic or random generation.
* **MVC (Model-View-Controller)**: Separation between business logic (`Models`), the user interface (`MainPage.fxml`), and the control logic (`WeatherController`).

## Features
* Creation of simple sensors with a choice of generator (Realistic or Random).
* Creation of virtual sensors.
* Sensor aggregation: add or remove contributing sensors to a virtual sensor with weight coefficient management.
* Real-time display updates via dedicated threads for each sensor.
* Deletion of existing sensors.

## Project Structure
* `Models`: Contains sensor logic and the base classes for the Observer pattern.
* `Generators`: Contains the various data generation strategies.
* `WeatherApp`: Contains the application entry point and JavaFX controllers.
* `resources`: FXML files defining the user interface.