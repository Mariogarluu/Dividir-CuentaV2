# Dividir Cuentas V2 💰

Una aplicación Android moderna y elegante para dividir cuentas entre comensales, con soporte para propinas y redondeo automático. Desarrollada con Jetpack Compose y Material Design 3.

## 📱 Descripción

DividirCuentas es una aplicación móvil que facilita el cálculo de cuentas compartidas en restaurantes, cafés o cualquier situación donde necesites dividir gastos entre varias personas. La aplicación calcula automáticamente el total con propina y cuánto debe pagar cada persona.

## ✨ Características

- **Cálculo automático en tiempo real**: Los resultados se actualizan instantáneamente mientras introduces los datos
- **División entre múltiples comensales**: Divide la cuenta entre cualquier número de personas
- **Soporte para propinas**: Añade un porcentaje de propina del 0% al 30%
- **Redondeo opcional**: Opción para redondear el total final
- **Interfaz moderna**: Diseñada con Material Design 3 y Jetpack Compose
- **Soporte multiidioma**: Disponible en español e inglés
- **UI responsiva**: Animaciones suaves y transiciones elegantes

## 🛠️ Tecnologías Utilizadas

- **Lenguaje**: Kotlin
- **UI Framework**: Jetpack Compose
- **Diseño**: Material Design 3
- **Arquitectura**: MVVM con Compose State Management
- **Mínimo SDK**: Android 14 (API 34)
- **Target SDK**: Android 15 (API 36)

## 📋 Requisitos

- Android Studio Hedgehog (2023.1.1) o superior
- JDK 11 o superior
- Dispositivo Android con API 34+ o emulador

## 🚀 Instalación

1. Clona el repositorio:
```bash
git clone https://github.com/Mariogarluu/Dividir-CuentaV2.git
```

2. Abre el proyecto en Android Studio:
```bash
cd Dividir-CuentaV2
```

3. Espera a que Gradle sincronice las dependencias

4. Ejecuta la aplicación:
   - Conecta un dispositivo Android (API 34+) o inicia un emulador
   - Haz clic en el botón "Run" (▶️) en Android Studio

## 📖 Uso

1. **Introduce el monto de la cuenta**: Escribe el total de la cuenta en el primer campo
2. **Indica el número de comensales**: Especifica entre cuántas personas se dividirá
3. **Activa el redondeo (opcional)**: Usa el switch para activar la función de propina y redondeo
4. **Ajusta la propina**: Cuando el redondeo está activado, usa el slider para seleccionar el porcentaje de propina (0-30%)
5. **Visualiza los resultados**: La aplicación mostrará:
   - Total a pagar (con propina si aplica)
   - Cantidad que debe pagar cada persona

## 🏗️ Estructura del Proyecto

```
Dividir-CuentaV2/
├── app/
│   ├── src/
│   │   ├── main/
│   │   │   ├── java/com/example/dividircuentas/
│   │   │   │   ├── MainActivity.kt          # Actividad principal y lógica de cálculo
│   │   │   │   └── ui/theme/                # Configuración de temas
│   │   │   │       ├── Color.kt
│   │   │   │       ├── Theme.kt
│   │   │   │       └── Type.kt
│   │   │   └── res/
│   │   │       ├── values/                   # Recursos en inglés
│   │   │       │   └── strings.xml
│   │   │       └── values-es/                # Recursos en español
│   │   │           └── string.xml
│   │   ├── androidTest/                      # Tests instrumentados
│   │   └── test/                             # Tests unitarios
│   └── build.gradle.kts
├── gradle/
├── build.gradle.kts
└── settings.gradle.kts
```

## 🧮 Lógica de Cálculo

La aplicación utiliza la siguiente fórmula:

```kotlin
Total = MontoBase × (1 + PorcentajePropina / 100)
TotalRedondeado = round(Total)  // Si redondeo está activado
CantidadPorPersona = Total / NúmeroDeComensales
```

## 🎨 Características de UI

- **Campos de texto** con validación numérica
- **Switch** para activar/desactivar la función de propina
- **Slider** animado para ajustar el porcentaje de propina
- **Animaciones** suaves con `AnimatedVisibility`
- **Material Design 3** con colores y tipografía modernos
- **Edge-to-edge display** para una experiencia inmersiva

## 🤝 Contribuciones

Las contribuciones son bienvenidas. Si deseas contribuir:

1. Haz un fork del proyecto
2. Crea una rama para tu característica (`git checkout -b feature/NuevaCaracteristica`)
3. Haz commit de tus cambios (`git commit -m 'Añadir nueva característica'`)
4. Haz push a la rama (`git push origin feature/NuevaCaracteristica`)
5. Abre un Pull Request

## 📝 Licencia

Este proyecto es de código abierto y está disponible bajo la licencia MIT.

## 👨‍💻 Autor

Desarrollado por [Mariogarluu](https://github.com/Mariogarluu)

## 📞 Contacto

Si tienes preguntas, sugerencias o encuentras algún problema, por favor abre un [issue](https://github.com/Mariogarluu/Dividir-CuentaV2/issues) en GitHub.

---

⭐ Si te gusta este proyecto, ¡no olvides darle una estrella!
