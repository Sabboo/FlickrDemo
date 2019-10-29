# FlickrDemo
### Overview
The main pupose of this demo is to consume Flickr Api and show List of images.
### Dependencies 
- ViewModel
- Data Binding
- RxJava & RxAndroid
- Retrofit
- Glide
- Koin
- Room
- Stetho
- PhotoView
- Ktx
### Decisions and Design
The first decision to make was that I will make use of ViewModel and LiveData in my presentation layer, So a presentation layer with MVVM Architecture the way I go.

Then what come in mind is that what dependency injection framework I will use, for this demo requirements I decided to use Koin, I have good experience with Dagger2 but for simplicity I used Koin as my dependecy injection framework.

I start with adding the base setup for the project, this setup consists of the first sight dependencies I am going to use, the required persmissions to ask the user for and the utilites classes and kotlin extensions that goes for every project. Then I prepare my dependency framework modules like NetModule (it basically has a base setup too) and prepare the other module for the upcomming features dependencies.

For each feature there are two packages; presentation for view related stuff and data for data related stuff. The first thing to handle the feature data layer members, these are mainly the models we are going to use, the remote api calls with retrofit setup and the cached data daos. After the data layer is ready we start to approach the presentation layer by creating the ViewModel for each feature to communicate with the repository for this feature to fetch the data from it. Then we with create the Activity/Fragment that will be responsible for this feature view and also communicate with the feature ViewModel.

That's it. Also note that many decisions will only arise when a different use cases appears or the project scale grows, For example I like to create the domain layer too in this clean architecture setup to ease testing but here it would be meaningless.
