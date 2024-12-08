# Descripción del proyecto:

Este proyecto es una API REST desarrollada en Spring que maneja solicitudes GET HTTP para proporcionar información sobre empleados y proyectos. Además, implementa la funcionalidad para generar archivos ZIP que contienen datos en formato XML, lo cual facilita la descarga de los datos en un formato estructurado.

El proyecto también incorpora programación concurrente utilizando CompletableFuture, permitiendo la ejecución paralela de tareas, como la obtención de los datos de empleados y proyectos. Para la serialización de objetos en formato XML, se utiliza la biblioteca JAXB, asegurando una conversión eficiente entre los objetos Java y el formato XML.

En resumen, el proyecto combina el uso de Spring para la creación de servicios RESTful con conceptos de programación concurrente, generando archivos ZIP con datos en XML y facilitando la descarga simultánea de múltiples archivos.

Enlace al repositorio
https://github.com/kety98/XMLEmployeeService/