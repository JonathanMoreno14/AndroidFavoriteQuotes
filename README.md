# AndroidFavoriteQuotes

- Android application that parses Json data within a RecyclerView

#### JSON Files
- Created this Json file for parsing data into applications for testing

[favoritequotes.json](https://gist.githubusercontent.com/JonathanMoreno14/d3032ce98e63b176cc839f2f046e2ca2/raw/b138a660b5bc92286e19c83175ab2fbb633f4e80/favoritequotes.json)


![ezgif com-resize 21](https://user-images.githubusercontent.com/11635523/43176764-d7e4d532-8f8a-11e8-86a5-1fccde79b29b.gif)

### Dependencies
```gradle

   implementation 'com.android.support:recyclerview-v7:27.1.1'
   implementation 'com.android.support:cardview-v7:27.1.1'
   implementation 'com.android.support:design:27.1.1'
   implementation 'com.github.bumptech.glide:glide:4.7.1'
   annotationProcessor 'com.github.bumptech.glide:compiler:4.7.1'
   implementation 'com.jakewharton:butterknife:8.8.1'
   annotationProcessor 'com.jakewharton:butterknife-compiler:8.8.1'
   implementation 'com.android.volley:volley:1.1.0'
   implementation 'de.hdodenhof:circleimageview:2.2.0'

```

### Android Manifest

```xml

android:screenOrientation="portrait"

```

### Color

**app/res/values/colors.xml**

```xml

<!--Background Color-->
<color name="darkBackground">#303030</color>
<color name="lightDarkCardVBackground">#444444</color>
<color name="backgroundText">#fff</color>


<!--Background Color Schema v2-->
<color name="mainBackgroundColor">#263238</color>
<color name="cardViewColor">#37474F</color>
<color name="authorBackgroundColor">#455A64</color>
<color name="mainTextColor">#757575</color>

<!-- ####################### -->
<color name="alternativeTextColor">#CFD8DC</color>

```
