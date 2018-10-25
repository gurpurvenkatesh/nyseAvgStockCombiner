# nyseAvgStockCombiner
MapReduce Program showcasing the use of Combiner. Also shows the custom class being created for the custom key,value types.

		1. Problem Statement : Get average volume traded for each stock per month.
		2. Coding approach
			a. Create a POJO class for parsing the data(NYSEParser.class)  : Since there are multiple input columns in the input file its better to have a POJO class.
			b. Identify Input & outpt format (TextInputFormat & TextFormatFormat since we are dealing with Text)
			c. Develop custom key to store 2 text values.
			d. Develop custom key/value to store 2 numeric values.
			e. Develop Mapper
				i. Input key – Line offset - LongWritable
				ii. Input Value – Each records from NYSE data. - Text
				iii. Output Key – Custom key calendar month(yyyy-mm) & Stock ticker. Hence use custom key(explained separately) which is created to store 2 text values.
				iv. Output value – Aggregate require sum of value & total number of stock per month. Hence use  custom key(explained separately) which is created to store 2 numeric values.
			f. Develop Combiner
				i. Input key – Same as output key.
				ii. Input Value – Same as output value.
				iii. Output Key – Custom key calendar month(yyyy-mm) & Stock ticker. Hence use custom key(explained separately) which is created to store 2 text values.
				iv. Output value – Aggregate require sum & total. Hence use  custom key(explained separately) which is created to store 2 numeric values.
			g. Develop Reducer
				i. Key & Value types are same as Combiner.				
		3. Input : Large Desk of cards : NYSE cv files. Present in Git.
		4. Code Git link : 
			a. Develop a POJO class which is used to parse the input file. This parsing is required as there are multiple input fields in a single record count.
			b. Develop custom class with 2 text values for key/value
				i. Implement WritableComparable
				ii. Have 2 private Text variables.
				iii. Generate the Constructors.
				iv. Generate the Getters & Setters.
				v. Implement the below methods from WritableComparable interface.
					a. ReadFields
					b. Write
					c. CompareTo
				vi. Generate the HashCode & equals method.
			c. Develop Simple Mapper with input & output key,value pairs.
			d. Develop combiner which gets the total  volume & total number of records.
      e. Develop REducer which calculates the average through total  volume & total number of records.
