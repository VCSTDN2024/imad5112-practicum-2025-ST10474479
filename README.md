### **README for IMAD Exam**

# Music Playlist App

- **Developer**: Bianca Thabisile Khumalo
- **Student Number**:ST10474479
- **Group**: Group 1
- **Course**: HAW
- **Subject**:IMAD5112

## Links
- **GitHub Repository**[https://github.com/VCSTDN2024/imad5112-assignment-2-ST10474479.git](https://github.com/VCSTDN2024/imad5112-practicum-2025-ST10474479.git)

## Project Overview

The **Music Playlist APP** is a mobile application developed as part of the exam for the IMAD module. This application was created using the **Kotlin** programming language through the application software **Android Studio**. 
The apps primary purpose is to allow the user to be able to rate songs, add comments, and input information about the artist.

The app was developed to meet the requirements of the exM, that includes creating a operating mobile app and utilizing GitHub for version control and CI/CD automation using GitHub Actions.


## App Purpose and Features

### Purpose:
The main purpose of the app is to is to allow the user to be able to rate songs, add comments, and input information about the artist.

### Key Features:
- Features: "Add to playlist button" - when the user clicks the button the user must be asked to enter the details for the playlist
- Features: "View button" - when clicked moves to the second screen whereby they will be able to view the playlist
- Features: "Exit button" - to exit the program 
- Features: "Display all button" - to display the playlist
- Features: "Average button" to calculate the average rating for the songs
- Features: "Main Screen button" return to the main screen
  
These features aim to provide a simple easy user friendly interface and very easy for managing tasks.

## Design Considerations

The design of the **Music Playlist App** was based on the following key considerations:

1. **User Experience**: The app is easy to use. Adding songs, rating them, and seeing your playlist is simple and clear.
   
2. **Responsiveness**: It works well on different screen sizes—big phones, small phones, or tablets.
   
3. **Effectiveness**: Every feature serves a clear purpose. Users can quickly add songs, assign ratings, leave comments, and view playlist stats without navigating through complex menus. The minimalist design focuses on essential functionality, helping users stay organized and in control of their music library.
   
4. **High Performance**: The app runs smoothly and fast. It doesn’t slow down your device or use too much battery.

## GitHub and GitHub Actions Utilization

This project was managed using **GitHub** for version control, where all code changes were committed and pushed regularly. GitHub enabled collaborative coding, allowing me to keep track of changes and maintain project integrity.

### GitHub Actions:
I utilized **GitHub Actions** to automate the build and deployment process. This includes:

- Running automated **tests** to ensure the app’s functionality.
- Compiling the app into **APK** and **AAB** files, which are the formats required for distribution.
- Uploading these build artifacts to GitHub for easy access.

The workflow ensures that my project is automatically built and tested every time I push changes, and it simplifies the process of delivering the final APK/AAB files for submission.

## Screenshots

### App Screenshots:
![image](https://github.com/user-attachments/assets/65fb9a56-648a-4306-8a38-9da514ebc706)

*Caption for screenshot 1: [Main Screen showing the "Add to playlist button" where the user will be able to enter the details of the playlist."View playlist button" to view the playlist the user has created. "Exit button" allows the user to exit the program]*

![image](https://github.com/user-attachments/assets/9630e8f5-9e5c-4247-ad4e-d0bf756e2a98)

*Caption for screenshot 2: [Playlist page where the user is allowed to enter the sing title, artist name , rating and cooments]*

![image](https://github.com/user-attachments/assets/e71072ae-1369-445e-a574-9920b65db4e4)

*Caption for screenshot 3: [Show casingsong titile, artist name , rating and comment]*

![image](https://github.com/user-attachments/assets/04e21f07-60cc-4e69-ab35-d63489190dec)
*Caption for screenshot 4: [Pop-up-message showing that the song has been added to the playlist]*

![image](https://github.com/user-attachments/assets/369b970d-e62d-40bf-bc6d-c67a470c0ed5)
*Caption for screenshot 5: [Detailed view screen where the playlist willl be displayed. display all button , calculate average and back to main button]*

![image](https://github.com/user-attachments/assets/376a679a-1b60-4c4f-97fa-8d782e5969f1)
*Caption for screenshot 6: [Playlist has been created]*

![image](https://github.com/user-attachments/assets/d4c36712-242c-43bd-8acb-4d175a84f669)
*Caption for screenshot 7: [Average ratings the songs got]*

![image](https://github.com/user-attachments/assets/1e9e70e2-c415-4221-85c4-a8372133f5ec)
*Caption for screenshot 8: [program exited]*

### Source code Screenshots Main Activity:
![image](https://github.com/user-attachments/assets/59948590-732f-4303-8bff-b791cc966d2b)

![image](https://github.com/user-attachments/assets/d07c0307-98de-4b49-9ffe-f5288461ed51) 

![image](https://github.com/user-attachments/assets/0dacafee-ea57-4b89-a750-2ef7fa2a7d10)

![image](https://github.com/user-attachments/assets/2ee3d587-0dd3-4961-bf66-cdb65fbf9de6)

![image](https://github.com/user-attachments/assets/f8d39d20-b6fc-418f-aac6-58c6ee5e194d)

![image](https://github.com/user-attachments/assets/80374f53-2139-4791-941a-90a70c1d2dba)

![image](https://github.com/user-attachments/assets/4fac8f69-1b1f-4df5-80b5-8e5a58e70a9f)

### Source code Screenshots Playlist:
![image](https://github.com/user-attachments/assets/60b92460-aac9-4bc2-bad8-d93523b72d9b)

![image](https://github.com/user-attachments/assets/b3edbc93-db1a-4487-9e01-81e6c4a3fe30)

![image](https://github.com/user-attachments/assets/01c7f1d7-cc3e-4e45-b235-26dec9c895d1)

![image](https://github.com/user-attachments/assets/18a0972d-42a4-4af5-9eda-23992a6dc154)

## Challenges and Learnings

During the development of this project, I encountered several challenges, including:

1. **Challenge 1**: Had difficulty adjusting the appropriate background for the background
   - **Solution**: I went through the various of options available for one to choose
   
2. **Challenge 2**: Issue with my code running
   - **Solution**: I had to relook at my code line for line to see what is missing and found open loops

From these challenges, I learned important lessons in debugging, using version control, and automating build processes with GitHub Actions.

## Future Enhancements

While the current version of the app provides the core functionality, there are several features that could be added in the future, including:

1. **Feature 1**: Add music-related quizzes or trivia games Give users fun challenges on music genres, artists, or song lyrics to boost engagement and help them discover new tracks.
2. **Feature 2**: Add a secure sign-in page Let users create an account so they can save their playlists across devices, rate songs, and keep their data safe.
3. **Feature 3**: Design a polished, modern welcome screen Use sleek visuals—like animated music notes, curated background images, and a catchy welcome message—to create a stylish first impression.

These enhancements would improve the app’s usability and make it even more versatile for every user.


## References
Reference listPinterest. (2017). Pinterest. [online] Available at: https://za.pinterest.com/pin/704813410473945427/c [Accessed 19 Jun. 2025].Sharepoint.com. (2025a). Redirecting. [online] Available at: https://advtechonline.sharepoint.com/:w:/r/sites/TertiaryStudents/_layouts/15/Doc.aspx?sourcedoc=%7B329C4CFA-B132-43AA-B95F-DE0776358126%7D&file=IMAD5112%20Practicum%20Guide.docx&action=default&mobileredirect=true [Accessed 19 Jun. 2025].Sharepoint.com. (2025b). Redirecting. [online] Available at: https://advtechonline.sharepoint.com/:w:/r/sites/TertiaryStudents/_layouts/15/Doc.aspx?sourcedoc=%7BA1FF62F0-8E1A-47BC-99BD-CA07AE24427D%7D&file=IMAD5112_MM.docx&action=default&mobileredirect=true.

## List of Figures

- **Figure 1** ![image](https://github.com/user-attachments/assets/65fb9a56-648a-4306-8a38-9da514ebc706)

- **Figure 2** ![image](https://github.com/user-attachments/assets/9630e8f5-9e5c-4247-ad4e-d0bf756e2a98)

- **Figure 3** ![image](https://github.com/user-attachments/assets/e71072ae-1369-445e-a574-9920b65db4e4)

- **Figure 4** ![image](https://github.com/user-attachments/assets/04e21f07-60cc-4e69-ab35-d63489190dec)

- **Figure 5**![image](https://github.com/user-attachments/assets/369b970d-e62d-40bf-bc6d-c67a470c0ed5)

- **Figure 6**![image](https://github.com/user-attachments/assets/376a679a-1b60-4c4f-97fa-8d782e5969f1)

- **Figure 7**![image](https://github.com/user-attachments/assets/d4c36712-242c-43bd-8acb-4d175a84f669)

- **Figure 8**![image](https://github.com/user-attachments/assets/1e9e70e2-c415-4221-85c4-a8372133f5ec)

- **Figure 9**![image](https://github.com/user-attachments/assets/59948590-732f-4303-8bff-b791cc966d2b)

- **Figure 10**![image](https://github.com/user-attachments/assets/d07c0307-98de-4b49-9ffe-f5288461ed51) 

- **Figure 11**![image](https://github.com/user-attachments/assets/0dacafee-ea57-4b89-a750-2ef7fa2a7d10)

- **Figure 12**![image](https://github.com/user-attachments/assets/2ee3d587-0dd3-4961-bf66-cdb65fbf9de6)

- **Figure 13**![image](https://github.com/user-attachments/assets/f8d39d20-b6fc-418f-aac6-58c6ee5e194d)

- **Figure 14**![image](https://github.com/user-attachments/assets/80374f53-2139-4791-941a-90a70c1d2dba)

- **Figure 15**![image](https://github.com/user-attachments/assets/4fac8f69-1b1f-4df5-80b5-8e5a58e70a9f)

- **Figure 16**![image](https://github.com/user-attachments/assets/60b92460-aac9-4bc2-bad8-d93523b72d9b)

- **Figure 17**![image](https://github.com/user-attachments/assets/b3edbc93-db1a-4487-9e01-81e6c4a3fe30)

- **Figure 18**![image](https://github.com/user-attachments/assets/01c7f1d7-cc3e-4e45-b235-26dec9c895d1)

- **Figure 19**![image](https://github.com/user-attachments/assets/18a0972d-42a4-4af5-9eda-23992a6dc154)

