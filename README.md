**Software Requirements**

-   Java SE 17
    ([Download](https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html))

-   Git command line tool
    (https://docs.github.com/en/get-started/quickstart/set-up-git) or
    [eGit](https://www.eclipse.org/egit/#:~:text=EGit%20is%20an%20Eclipse%20Team,history%20very%20fast%20and%20versatile.)
    for version control natively in Eclipse

    -   additionally, an active github account is needed

-   Eclipse 2021 IDE for Enterprise Java and Web Developers -- 2021-12
    ([Download](https://www.eclipse.org/downloads/packages/release/2021-12))
    -   For running JUnit tests, JUnit 5.8.1 is required ([Download](https://search.maven.org/search?q=g:org.junit.jupiter%20AND%20v:5.8.1))
    
**Minimum Hardware Requirements**
- Required Java version:
    - Java SE 17 ([Download](https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html))
- Memory:
    - 512 MB
- Free Disk Space
    - 500 MB
- Processor Speed
    - 1 GHZ
**Recommended Hardware Requirements**
- Required Java version:
    - Java SE 17 (Download)
- Memory:
    - 1GB or more
- Free Disk Space:
    - 1GB or more
- Processor Speed:
    - 1.5 Ghz or more


**Working with the Data Structures workspace in your IDE**

**Using Smart Import to Load the Workspace into Eclipse**

-   Ensure the required prerequisites are installed and functioning. We
    will use eGit to import the workspace from GitHub.

-   Create a folder in your desired directory to store the eclipse
    workspace. Browse to that folder when starting up Eclipse and
    **Launch** to initialize the workspace.

-   Inside Eclipse:

    File -\> Import -\> Git -\> Projects from Git (with smart import)
    -\> Clone URI

-   For URI enter in the https url from the repository

    <https://github.com/samthangiah/Spring-2022---Data-Structures.git>

-   Authenticate by providing your github username and password.
    Sometimes, you will need to generate a personal access token when
    your password does not authenticate you. Follow this
    [stackoverflow](https://stackoverflow.com/questions/54485527/authentication-failed-cannot-clone-remote-repository-by-git-only-occurred-in)
    post as a workaround.

-   Select the master branch to clone from the repository and click
    **Next**.

-   Click **Next** until you import the repository, and then click
    **Finish.**

**Manually Downloading the Workspace from Github**

-   Begin by navigating to the URL of the github repository
    (<https://github.com/samthangiah/Spring-2022---Data-Structures>).
    Ensure you are currently in the master branch. Only the master
    branch will contain the most stable build and will ensure that there
    are no errors when compiling the examples. To check and make sure
    you are in the master branch see below:
    
    ![Picture1](https://user-images.githubusercontent.com/97899902/155327277-015e23f8-d66d-48a3-aa68-91f32794ed5a.png)


-   After validating that you are in the master branch, click on the
    drop down arrow for **Code** and click **Download
    Zip:**
    
    ![Picture2](https://user-images.githubusercontent.com/97899902/155327354-7e4da9a4-4a9b-4afe-a762-a774948de7b2.png)


-   The downloaded zip folder will be stored in your **Downloads**
    folder if you are using a windows device. Use your desired ZIP tool
    (WinRAR, 7zip) to unzip the archive. Open up the archive and extract
    the contents to your desired directory. Be sure to remember where
    you have extracted the zip folder to as we will need to use the
    location in a later step.

-   Create a folder in your desired directory to store your eclipse
    workspace.

-   Launch Eclipse and next to the **Workspace:** dropdown menu select
    **Browse..**
    
    ![Picture3](https://user-images.githubusercontent.com/97899902/155327416-6ef7cd56-4acd-4172-b767-957a94799707.png)


-   Navigate to the location where we created the folder for our eclipse
    workspace. You can use the root directory of the extracted zip
    folder, or you can create your own folder. Either method works. For
    our example we are going to use the
    **Spring-2022\-\--Data-Structures-master** folder to store our
    eclipse workspace.

-   After launching your workspace for the first time, you will need to
    import the downloaded workspace from github. In eclipse, navigate to
    **File\>Import**. This will open the Import wizard. Open the
    **General** folder and select **Existing Projects into
    Workspace**
    
    ![Picture4](https://user-images.githubusercontent.com/97899902/155327460-338b5445-9964-4003-9df8-02c863a47acc.png)

-   In the **Import Projects** wizard, select **Browse...** next to the
    **Select root directory:**
    section.
    
    ![Picture5](https://user-images.githubusercontent.com/97899902/155327512-1098aeb5-06d5-4165-8f67-0da00e499ae2.png)

-   Now, we will need to navigate to the directory where we extracted
    the unzipped contents of our github repository. Once there,
    double-click on the **Spring-2022\-\--Data-Structures-master**
    folder, click on the **DataStructures** folder, and press **Select
    Folder**
    
    ![Picture6](https://user-images.githubusercontent.com/97899902/155327610-06084c67-abeb-43e4-941e-345a81a29baf.png)

-   After selecting the workspace to be
    imported, you will notice the workspace is enabled in the
    **Projects:** section. Click **Finish.**
    
    ![Picture7](https://user-images.githubusercontent.com/97899902/155327717-ac7d6038-d866-4ff1-8b8e-ab5cad5a9024.png)


-   Opening the **Package Explorer** view (**Window \> Show View \>
    Package Explorer)** will now show the available packages and the
    workspace
    structure:
    
    ![Picture8](https://user-images.githubusercontent.com/97899902/155327763-01a0cbbf-c822-43e9-a2bf-8a52fa2cf187.png)

    
