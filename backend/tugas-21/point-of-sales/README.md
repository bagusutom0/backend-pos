# Cara run project

## base url: http://localhost:8080/api/v1

## tugas 13:
1. Jalankan Project
   ```bash
   mvn spring-boot:run
   ```

2. Gunakan endpoint /register dengan contoh body:
   ```json
   {
      "name": "manager",
      "role": "MANAGER",
      "username": "manager",
      "password": "manager"
   }
   ```

3. Salin token yang dihasilkan dari proses register manager.

4. Gunakan endpoint /category/add dengan Bearer Token, dan body:
   ```json
   {
      "name": "Ring"
   }
   ```

5. Gunakan endpoint /product/add dengan Bearer Token, dan body :
   ```json
   {
      "image": [
         "https://ae-pic-a1.aliexpress-media.com/kf/Sb976fbea4536476c88e1476f24b5325eG.jpg_220x220q75.jpg_.avif",
         "https://ae-pic-a1.aliexpress-media.com/kf/S342a75e1cc624ec4a0970b8fadfdcafdD.jpg_220x220q75.jpg_.avif",
         "https://ae-pic-a1.aliexpress-media.com/kf/S326ce68d7b4d40a5ab7814ad31458b9cc.jpg_220x220q75.jpg_.avif",
         "https://ae-pic-a1.aliexpress-media.com/kf/Seb29bb0cb2f74267a4f6a689940b11faD.jpg_220x220q75.jpg_.avif"
      ],
      "name": "OVAL GEMSTONE SIGNET RING",
      "price": 41,
      "review": ["4", "200k"],
      "description": "This Signet's About To Be Your New Signature. It's An Approachable Power Move, Handcrafted in Sterling Silver.",
      "colour": ["#ef4444", "#6b7280", "#14b8a6"],
      "size": ["2", "3.5", "4"],
      "length": ["18", "20", "22", "26", "28"],
      "stock": 200,
      "categoryId": 1
   }
   
