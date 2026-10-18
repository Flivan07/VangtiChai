CSE 489: Mobile Application Development
Assignment 1: VangtiChai

Name: Mohammad Farhan Labib
Student ID: 22201635
Section: 1

Language: Kotlin
Minimum SDK: API 21 (Android 5.0 Lollipop)

Devices tested:
1. Pixel 10 Pro XL, portrait and landscape
2. Pixel Tablet, portrait and landscape

Notes:
- Amount input is limited to 9 digits to avoid integer overflow.
- State (amount and change list) is saved on rotation using onSaveInstanceState.
- Alternative layouts: layout, layout-land, layout-sw600dp, layout-sw600dp-land.
- All text sizes, margins and padding are defined in sizes.xml
  (values and values-sw600dp); all strings are in strings.xml.