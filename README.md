# Hadoop-project

Salooja:  Hadoop map-reducing algorithm, data analysis
Vatsalya: Spark algorithm, data analysis



Market Basket Analysis:

Market Basket Analysis(MBA) is a popular data mining technique,frequently used by marketing and ecommerce professionals to reveal affinities between individual products or product groupings.
Using for identifying items likely to be purchased together in a large collection of supermarket sales transactions and association rule mining finds correlation between items in a set of transactions.
Provides marketers can increase their business by implementing more marketing strategies like to place correlated products next to each other on store shelves or online so that customers can buy more items or making the customers to know what are the frequent items that are bought.
MBA is popular for analysis of card purchases, analysis of telephone calling patterns, Identification of fraudulent medical insurance claims, analysis of telecom service purchases and analysis of daily/weekly purchases at major online retailers like Amazon.com.

Market Basket Analysis key concepts:
 Market Basket Analysis (MBA) is an application of data mining algorithms aimed at identifying frequent patterns and co-occurrence relationships. 
Given a set of input data, the MBA returns the paired products items(according to our input ) and their number of occurrences in transaction 
Output is useful to produce association rules
Support: the percentage of cases in which the two events A and B occur together on the total of the considered cases (e.g., the number of receipts in which A and B appear together divided by the total number of receipts); Which gives the frequency of occurrence of an item
Confidence: the percentage of cases in which the two events A and B occur together on the total of cases where A occurs (e.g., the number of receipts that contain both products A and B divided by the total number of receipts where A appears).How often lefthand side of the rule appear with the right hand side.


Goals of Market Basket Analysis
	
MBA program takes raw data sets as inputs and produce the output in paired manner based on the transactions.We used the MapReduce program for identifying the key-value pairs.MapReduce solution for data mining analysis to find most frequently occurring pair of products(order of 1,2….) in basket at a given supermarket or ecommerce store.
Java with Hadoop and Spark with java and scala are used for finding frequent patterns.
Run MapReduce job for 100 data sets and find out the analysis



Process For Solution

The dataset  contains nominal values only 
Considering one attributes .Product name for given period of time
Each tuple is a transaction of a given customer 
The “order of N”(name of products) will be passed as an argument to the mapReduce driver,Which will then set it in Hadoop’s configuration object.
Finally , the map() method will read that parameter from hadoop’s configuration object in the setup() method.
We are getting most each item set with its number of occurance as the output.


Market Basket Analysis Algorithm
 Market Basket Analysis is one of the Data Mining approaches to analyze the association of data set. The basic idea is to find the associated pairs of items in a store when there are transaction data sets as in Figure 1. If store owners list a pair of items that are frequently occurred, they could control the stocks more intelligently, to arrange items on shelves and to promote items together etc. Thus, they should have much better opportunity to make a profit by controlling the order of products and marketing. 

Input Data:
Transaction 1: cracker, icecream, beer 
Transaction 2: chicken, pizza, coke, bread 
Transaction 3: baguette, soda, hering, cracker, beer
Transaction 4: bourbon, coke, turkey
Transaction 5: sardines, beer, chicken, coke 
Transaction 6: apples, peppers, avocado, steak
Transaction 7: sardines, apples, peppers, avocado, steak
                 

Output Data:

cracker, beer 6,836
artichok, avocado 5,624
avocado, baguette 5,337
bourbon, cracker 5,299
baguette, beer 5,003 
corned, hering 4,664
beer, hering 4,566 … 
