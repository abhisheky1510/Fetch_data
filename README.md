The code is inside the MyApplication2 folder. The location of the important folders of the app are given below - 

1. You can find the **MainActivity.java** file at the following location -> MyApplication2 > app > src > main > java/com/fetch_app > **MainActivity.java**

2. You can find the **item.xml** (Recycler view's repeating element's layout file) at the following location  MyApplication2 > app > src > main > res > layout > **item.xml**

3. You can find the **activity_main.xml** at the following location MyApplication2 > app > src > main > res > layout > **activity_main.xml**

4. You can find the Adapter **DataDetailsAdapter.java** at the following location MyApplication2 > app > src > main > java/com/fetch_app > adapter > **DataDetailsAdapter.java**

5. You can find the class **DataDetails.java** at the following location MyApplication2 > app > src > main > java/com/fetch_app > model > **DataDetails.java**

**Working** - 

1. The data is fetched by making an API call using volley.
2. The data is parsed to extract the three fields (id,listid, and name), and only those rows of data are considered who have nonnull names.
3. The data is being sorted first by listid and then by name.
4. The app initializes RecyclerView with a custom adapter named DataDetailsAdapter, and the LayoutManager is set to display the data vertically.
5. The sorted data is then passed to the RecyclerView Adapter, which updates the displayed list and displays the item in the form of id followed by list id followed by name.

**Note** - I have run the application on pixel 8 on the latest API level 34. The compileSDK and targetSDK are 34 and 33, respectively.

Below is the attached screenshot of the running application which displays the sorted data fetched from the given URL.

<img width="952" alt="fetch_assignment" src="https://github.com/abhisheky1510/Fetch_data/assets/67820233/b32fa3f6-2c93-4da9-af52-9b6da17c2c5b">
