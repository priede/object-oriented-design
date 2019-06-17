```
CSCI 3 353 Object Oriented Design
Homework Assignment 8
Due Wednesday, April 11
```
Your task is to write a flexible system for analyzing stocks. The system contains various
classes, called _stock analysts_ , whose job is to make predications based on various
aspects of a company. For example, there might be an analyst that makes predictions
based on the company's earnings history, one that makes predications based on the
price-earnings ratio, one that understands the broad trends in different market segments
(e.g. "auto stocks are bad; technology stocks are good"), and so on.

Each analyst will implement the _StockAnalyst_ interface. This interface has two methods:

- the method _confidenceLevel_ , which returns a value between 0.0 and 1.0 that
    denotes the predicted probability that the company's stock will rise in value;
- the method _reasons_ , which returns a string explaining the reasons for this value.

The stock analyst classes are organized according to the decorator pattern, as in the
following diagram:

The base classes are _Neutral_ , _Bullish_ , and _Bearish_. Their confidence levels are based
on the market as a whole, and apply equally to all companies. Assume that _Neutral_
always gives a confidence level of 50%, _Bullish_ 7 0%, and _Bearish_ 3 0%.

In this assignment, you will also write three decorator classes. The _PERatioAnalyst_
class calculates the company's Price-Earnings ratio by dividing the current price by
current earnings. A PE ratio of 12 is considered to be average. A smaller ratio
indicates an underpriced stock, and therefore a higher confidence that it will increase in
price; and a higher ratio indicates an overpriced stock and a consequent lower level of
confidence. Let's say that the analyst uses the following formula to generate its
confidence level:

```
confidence = 1 - (PEratio / 24)
```
```
<interface>
StockAnalyst
confidenceLevel()
reasons()
cost()
```
```
Bearish
Neutral Bullish AnalystDecorator
```
```
PEratioAnalyst NameAnalyst SegmentAnalyst
```

The _SegmentAnalyst_ class has a preset confidence level for certain market segments.
Let's assume that auto stocks have a confidence of 20%, and technology stocks have a
confidence of 80%. For other stocks, the analyst has no opinion.

The _NameAnalyst_ class bases its confidence level on the company's name. Let's
assume that the analyst has 100% confidence in companies that begin with the letter
"A", and has no opinion about other companies.

If a decorator analyst needs more information about a company than was given, then
the analyst will have no opinion about the company.

The individual confidence levels of each analyst must be combined into a single overall
confidence level. The _confidenceLevel_ method for an analyst denotes this overall level.
In particular, the overall confidence level of a decorator analyst is the average of its own
confidence and the overall confidence of the analyst that it decorates. If the analyst has
no opinion, then its overall confidence level is the same as the analyst it decorates.

Note that the overall confidence of a chain of decorators will differ depending on the
order that the decorators appear in the chain. In particular, the opinions of the outer
decorators affect the overall confidence more than the inner ones. Consider this a
feature, not a bug.

The _reasons_ method operates similarly to _confidenceLevel_. If an analyst has an opinion
about a company, then it also has a reason for that confidence. For example, the
reason given by the segment analyst for its low confidence in auto stocks might have
the corresponding reason "Auto stocks are a bad risk.". The overall reasons for a chain
of analysts is the concatenation of their individual reasons.

The information about each company is stored in a text file. The file can contain an
arbitrary number of lines, each of which denotes information about the company. The
first word on each line is a keyword, such as "name", "marketsegment", "earnings",
"shareprice", etc. The remainder of the line contains data about that keyword. An
example file is _apple.txt_ , which you can download.

You should write a class _StockInfo_ , whose constructor reads a specified file, extracts its
information, and saves it in a data structure of your choice. The class should have
methods that the analysts can call to retrieve the data they need.

I have written a test file named _HW8Test.java_ , which you should download. The code
asks the user to interactively specify different decorator chains, and then prints the


confidence level and reasoning corresponding to that chain. Here is some example
output from my program:

```
File name: apple.txt
General outlook (0=neutral, 1=bearish, 2=bullish): 2
Analyst: (0=done, 1=segment, 2=PEratio, 3=name): 3
Analyst: (0=done, 1=segment, 2=PEratio, 3=name): 2
Analyst: (0=done, 1=segment, 2=PEratio, 3=name): 1
Analyst: (0=done, 1=segment, 2=PEratio, 3=name): 0
```
```
Confidence level is 0.
Reasoning: I think the market is going up.
I love companies that begin with 'A'.
The PE ratio is 14.269438906294504, which is bad.
Tech stocks are a good risk.
```
Here is another:

```
File name: apple.txt
General outlook (0=neutral, 1=bearish, 2=bullish): 0
Analyst: (0=done, 1=segment, 2=PEratio, 3=name): 0
```
```
Confidence level is 0.
Reasoning: The market's future is unclear.
```
When you are done, create a zip file containing the ten files _StockAnalyst.java_ ,
_Bearish.java_ , _Bullish.java_ , _Neutral.java_ , _AnalystDecorator.java_ , _PEratioAnalyst.java_ ,
_SegmentAnalyst.java_ , _NameAnalyst.java_ , _StockInfo.java_ , and _HW8Test.java_ , and submit
it to Canvas. Make sure that all of your java files are in the package _hw 8_.


