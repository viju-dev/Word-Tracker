# Design :
### we are  using simple design here.

### • Class : 
#### – pageReader : We will create pageReader class:

### • Attributes :
#### – pageIndex : It will maintain index of page.
#### – excludeWordsList : It will contain list of words which needs to be excluded
#### – stringIndexMap : It will maintain words with their pageIndex and we will use TreeMap so the words sorting order in map will get maintain 

### • Methods:
#### – pageReader :  This is a constructor which will read page by path and  will set pageIndex.
#### – searchText : This method will store words with its indexes in stringIndexMap.
#### – addExcludeWords : this method add words from excluded file to excludeWordsList.
#### – printOutput : This method will iterate through stringIndexMap store all words with indexes in string and return string.
#### – write : This method will call printOutput method and will write that data inside index.txt file

