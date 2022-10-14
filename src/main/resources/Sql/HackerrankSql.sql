-- Query all columns for all American cities in the CITY table with populations larger than 100000. The CountryCode for America is USA.
SELECT * FROM CITY WHERE COUNTRYCODE = 'USA' AND POPULATION > 100000

-- Query the NAME field for all American cities in the CITY table with populations larger than 120000. The CountryCode for America is USA
SELECT NAME FROM CITY WHERE COUNTRYCODE = 'USA' AND POPULATION > 120000

-- Query all columns (attributes) for every row in the CITY table.
SELECT * FROM CITY

-- Query all columns for a city in CITY with the ID 1661.
SELECT * FROM CITY WHERE ID = 1661

-- Query all attributes of every Japanese city in the CITY table. The COUNTRYCODE for Japan is JPN.
SELECT * FROM CITY WHERE COUNTRYCODE = 'JPN'

-- Query the names of all the Japanese cities in the CITY table. The COUNTRYCODE for Japan is JPN.
    SELECT NAME FROM CITY WHERE COUNTRYCODE = 'JPN'

--  Query a list of CITY and STATE from the STATION table.
    SELECT CITY, STATE FROM STATION

-- Query a list of CITY names from STATION for cities that have an even ID number. Print the results in any order, but exclude duplicates from the answer.
    SELECT DISTINCT CITY FROM STATION WHERE ID % 2 = 0

-- Find the difference between the total number of CITY entries in the table and the number of distinct CITY entries in the table.
    SELECT COUNT(CITY) - COUNT(DISTINCT CITY) FROM STATION

-- Query the list of CITY names starting with vowels (i.e., a, e, i, o, or u) from STATION. Your result cannot contain duplicates.
        SELECT DISTINCT CITY FROM STATION WHERE CITY REGEXP '^[aeiou]'

-- Query the list of CITY names ending with vowels (a, e, i, o, u) from STATION. Your result cannot contain duplicates.
        SELECT DISTINCT CITY FROM STATION WHERE CITY REGEXP '[aeiou]$'

--  Query the list of CITY names from STATION which have vowels (i.e., a, e, i, o, and u) as both their first and last characters. Your result cannot contain duplicates.
        SELECT DISTINCT CITY FROM STATION WHERE CITY REGEXP '^[aeiou].*[aeiou]$'

-- Query the list of CITY names from STATION that do not start with vowels. Your result cannot contain duplicates.
        SELECT DISTINCT CITY FROM STATION WHERE CITY NOT REGEXP '^[aeiou]'

-- Query the list of CITY names from STATION that do not end with vowels. Your result cannot contain duplicates.
SELECT DISTINCT CITY FROM STATION WHERE CITY NOT REGEXP '[aeiou]$'

--  Query the list of CITY names from STATION that either do not start with vowels or do not end with vowels. Your result cannot contain duplicates.
SELECT DISTINCT CITY FROM STATION WHERE CITY NOT REGEXP '^[aeiou]' OR CITY NOT REGEXP '[aeiou]$'

-- Query the list of CITY names from STATION that do not start with vowels and do not end with vowels. Your result cannot contain duplicates.
SELECT DISTINCT CITY FROM STATION WHERE CITY NOT REGEXP '^[aeiou]' AND CITY NOT REGEXP '[aeiou]$'

-- Query the two cities in STATION with the shortest and longest CITY names, as well as their respective lengths (i.e.: number of characters in the name). If there is more than one smallest or largest city, choose the one that comes first when ordered alphabetically.
SELECT CITY, LENGTH(CITY) FROM STATION ORDER BY LENGTH(CITY), CITY ASC LIMIT 1;
SELECT CITY, LENGTH(CITY) FROM STATION ORDER BY LENGTH(CITY) DESC LIMIT 1;

-- Query the Name of any student in STUDENTS who scored higher than  Marks. Order your output by the last three characters of each name. If two or more students both have names ending in the same last three characters (i.e.: Bobby, Robby, etc.), secondary sort them by ascending ID.
SELECT NAME FROM STUDENTS WHERE MARKS > 75 ORDER BY RIGHT(NAME, 3), ID ASC;

-- Write a query that prints a list of employee names (i.e.: the name attribute) from the Employee table in alphabetical order.
SELECT NAME FROM EMPLOYEE ORDER BY NAME ASC;

-- Write a query that prints a list of employee names (i.e.: the name attribute) for employees in Employee having a salary greater than  per month who have been employees for less than  months. Sort your result by ascending employee_id.
SELECT NAME FROM EMPLOYEE WHERE SALARY > 2000 AND MONTHS < 10 ORDER BY EMPLOYEE_ID ASC;

-- Given the CITY and COUNTRY tables, query the names of all cities where the CONTINENT is 'Africa'.
-- Note: CITY.CountryCode and COUNTRY.Code are matching key columns.
SELECT CITY.NAME FROM CITY INNER JOIN COUNTRY ON CITY.COUNTRYCODE = COUNTRY.CODE WHERE COUNTRY.CONTINENT = 'Africa';

-- Given the CITY and COUNTRY tables, query the names of all the continents (COUNTRY.Continent) and their respective average city populations (CITY.Population) rounded down to the nearest integer.
-- Note: CITY.CountryCode and COUNTRY.Code are matching key columns.
SELECT COUNTRY.CONTINENT, FLOOR(AVG(CITY.POPULATION)) FROM CITY INNER JOIN COUNTRY ON CITY.COUNTRYCODE = COUNTRY.CODE GROUP BY COUNTRY.CONTINENT;


-- You are given two tables: Students and Grades. Students contains three columns ID, Name and Marks.
-- Ketty gives Eve a task to generate a report containing three columns: Name, Grade and Mark. Ketty doesn't want the NAMES of those students who received a grade lower than 8. The report must be in descending order by grade -- i.e. higher grades are entered first. If there is more than one student with the same grade (8-10) assigned to them, order those particular students by their name alphabetically. Finally, if the grade is lower than 8, use "NULL" as their name and list them by their grades in descending order. If there is more than one student with the same grade (1-7) assigned to them, order those particular students by their marks in ascending order.
SELECT CASE WHEN GRADE < 8 THEN NULL ELSE NAME END, GRADE, MARKS FROM STUDENTS INNER JOIN GRADES ON STUDENTS.ID = GRADES.STUDENT_ID ORDER BY GRADE DESC, NAME, MARKS;

-- Given the CITY and COUNTRY tables, query the sum of the populations of all cities where the CONTINENT is 'Asia'.
-- Note: CITY.CountryCode and COUNTRY.Code are matching key columns.
SELECT SUM(CITY.POPULATION) FROM CITY INNER JOIN COUNTRY ON CITY.COUNTRYCODE = COUNTRY.CODE WHERE COUNTRY.CONTINENT = 'Asia';

-- Julia just finished conducting a coding contest, and she needs your help assembling the leaderboard! Write a query to print the respective hacker_id and name of hackers who achieved full scores for more than one challenge. Order your output in descending order by the total number of challenges in which the hacker earned a full score. If more than one hacker received full scores in same number of challenges, then sort them by ascending hacker_id.
SELECT HACKER_ID, NAME FROM HACKERS WHERE SCORE = 100 GROUP BY HACKER_ID HAVING COUNT(*) > 1 ORDER BY COUNT(*) DESC, HACKER_ID ASC;

Write a query identifying the type of each record in the TRIANGLES table using its three side lengths. Output one of the following statements for each record in the table:

-- Query a count of the number of cities in CITY having a Population larger than .
SELECT COUNT(*) FROM CITY WHERE POPULATION > 100000;

-- Query the total population of all cities in CITY where District is California.
SELECT SUM(POPULATION) FROM CITY WHERE DISTRICT = 'California';