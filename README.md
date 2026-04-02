Approach Taken:

The app was built using Android Jetpack Compose with MVVM architecture for clean separation of UI, business logic, and data. Product data is fetched from a dummy API / local JSON, simulating backend integration. The Order App allows users to select products, enter quantity, and calculate total price with MOQ validation and Dealer/Retail pricing. The Barcode Scanner uses the device camera to scan barcodes and applies a simple rule to determine validity (even = valid, odd = invalid).

<img width="280" height="516" alt="image" src="https://github.com/user-attachments/assets/bf28c6f2-23a6-47d4-9162-2398cc22773e" />


<img width="271" height="486" alt="image" src="https://github.com/user-attachments/assets/08989148-d6bb-4b18-ad30-30998e9a6192" />


<img width="276" height="503" alt="image" src="https://github.com/user-attachments/assets/5f48a5ec-c4f8-436b-b5ca-3ebee49df952" />




Challenges Faced:
Implementing dynamic selection and highlighting of products in the product list.
Handling state management for quantity input, customer type, and total price simultaneously in a reactive Compose UI.
Integrating barcode scanning without a real backend and simulating product mapping.


What Would Be Improved:
Connect the app to a real backend API to fetch products and store orders.
Add order history and user accounts for more realistic B2B functionality.
Enhance UI/UX with better themes, animations, and responsive design for tablets.
Include unit tests and validation messages for better reliability.
