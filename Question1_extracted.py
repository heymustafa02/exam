#Slip1 Q1
# Q1_DetectOutliers.py
import pandas as pd
import numpy as np
import matplotlib.pyplot as plt

stud = pd.read_csv("Student.csv")

# Boxplot before fixing
stud.boxplot(column=['math score'])
plt.title("Before Fixing Outliers")
plt.show()

Q1 = stud['math score'].quantile(0.25)
Q3 = stud['math score'].quantile(0.75)
IQR = Q3 - Q1
lower = Q1 - 1.5 * IQR
upper = Q3 + 1.5 * IQR

stud['math score'] = np.clip(stud['math score'], lower, upper)

# Boxplot after fixing
stud.boxplot(column=['math score'])
plt.title("After Fixing Outliers")
plt.show()


# ---- New Cell ----

#slip2 Q1
# Q1_MissingValues.py
import pandas as pd

loan = pd.read_csv("loan_data_set.csv")

loan['Gender'].fillna("Male", inplace=True)
loan['Married'].fillna("Yes", inplace=True)
loan['Dependents'].fillna(0, inplace=True)
loan['Self_Employed'].fillna("No", inplace=True)
loan['LoanAmount'].fillna(loan['LoanAmount'].median(), inplace=True)
loan['Loan_Amount_Term'].fillna(360.0, inplace=True)
loan['Credit_History'].fillna(1.0, inplace=True)

print("Missing values handled successfully.")
print(loan.isnull().sum())


# ---- New Cell ----

#slip3 Q1
# Q1_Correlation.py
import pandas as pd
import seaborn as sns
import matplotlib.pyplot as plt

stud = pd.read_csv("Student.csv")

corr = stud.corr(numeric_only=True)
print(corr)

sns.heatmap(corr, annot=True)
plt.show()


# ---- New Cell ----

#slip4
# Q7_EDA.py
import pandas as pd

add = pd.read_csv("Addidas.csv")

print(add.head())
print(add.tail())
print(add.sample())
print(add.info())
print(add.describe())
print(add.isnull().sum())



# ---- New Cell ----

#slip5
# Q8_Visualization.py
import pandas as pd
import matplotlib.pyplot as plt
import seaborn as sns

stud = pd.read_csv("Student.csv")

# Histogram
plt.hist(stud['math score'])
plt.title("Math Score Distribution")
plt.show()

# Pie Chart
stud['race/ethnicity'].value_counts().plot(kind='pie', autopct='%1.1f%%')
plt.show()

# Bar Graph
stud['race/ethnicity'].value_counts().plot(kind='bar')
plt.show()

# Heatmap
sns.heatmap(stud.corr(numeric_only=True), annot=True)
plt.show()


# ---- New Cell ----

#slip6

import seaborn as sns
import matplotlib.pyplot as plt
from sklearn.metrics import confusion_matrix, ConfusionMatrixDisplay


data = {
    'y_actual': ["Yes","No","No","Yes","No","Yes","No","No","Yes","No","Yes","No"],
    'y_predic': ["Yes","Yes","No","Yes","No","Yes","Yes","No","Yes","No","No","No"]
}

y_actual = data['y_actual']
y_pred = data['y_predic']

# Confusion Matrix
cm = confusion_matrix(y_actual, y_pred, labels=["Yes","No"])
print("Confusion Matrix:\n", cm)

# Heatmap Visualization
plt.figure(figsize=(5,4))
sns.heatmap(cm, annot=True, fmt='d', cmap='Blues',
            xticklabels=["Pred Yes","Pred No"],
            yticklabels=["Actual Yes","Actual No"])
plt.xlabel("Predicted")
plt.ylabel("Actual")
plt.title("Confusion Matrix")
plt.show()


#True Positives (TP = 4): Predicted Yes and actually Yes

#False Negatives (FN = 1): Predicted No but actually Yes

#False Positives (FP = 1): Predicted Yes but actually No

#True Negatives (TN = 6): Predicted No and actually No

# ---- New Cell ----

#slip7
# Q11_Skewness.py
import pandas as pd
import seaborn as sns
import matplotlib.pyplot as plt

add = pd.read_csv("Addidas.csv")

sns.histplot(add['Price_per_Unit'], kde=True)
plt.title("Skewness in Adidas Price per Unit")
plt.show()


# ---- New Cell ----

#slip8
# Q5_Correlation.py
import pandas as pd
import seaborn as sns
import matplotlib.pyplot as plt

stud = pd.read_csv("Student.csv")

corr = stud.corr(numeric_only=True)
print(corr)

sns.heatmap(corr, annot=True)
plt.show()


# ---- New Cell ----

#slip9
# Q13_Regplot.py
import pandas as pd
import seaborn as sns
import matplotlib.pyplot as plt

news = pd.read_csv("NewspaperData.csv")

sns.regplot(x="daily", y="sunday", data=news)
plt.show()



# ---- New Cell ----

#slip10
# Q14_TrainTestSplit.py
import pandas as pd
from sklearn.model_selection import train_test_split

news = pd.read_csv("NewspaperData.csv")

x = news[['daily']]
y = news[['sunday']]

xtrain, xtest, ytrain, ytest = train_test_split(x, y, test_size=0.2)
print("X-train:\n", xtrain.head())
print("X-test:\n", xtest.head())


# ---- New Cell ----

#slip 11
import matplotlib.pyplot as plt
from sklearn.model_selection import train_test_split
n = int(input("Enter number of data points: "))

X = []
Y = []

# Input X and Y values
for i in range(n):
    print(f"\nData point {i+1}:")
    x = float(input("Enter X value: "))
    y = float(input("Enter Y value: "))
    X.append(x)
    Y.append(y)
    # Split the data into training and testing sets (80% training, 20% testing)
X_train, X_test, Y_train, Y_test = train_test_split(X, Y, test_size=0.2, random_state=42)

# Plot the data using scatter plot
plt.scatter(X_train, Y_train, color='blue', label='Training Data')
plt.scatter(X_test, Y_test, color='red', label='Testing Data')
plt.xlabel("X values")
plt.ylabel("Y values")
plt.title("Scatter Plot of Training and Testing Data")
plt.legend()
plt.grid(True)
plt.show()

# ---- New Cell ----

#Slip12
# Q4_ChangeDatatype.py
import pandas as pd

stud = pd.read_csv("Student.csv")

print("Before:\n", stud.dtypes)
stud['math score'] = stud['math score'].astype(float)
print("After:\n", stud.dtypes)


# ---- New Cell ----

#slip13
same as slip7

# ---- New Cell ----

#slip14
same as slip3

# ---- New Cell ----

#slip15
same as slip2

# ---- New Cell ----

#slip16
same as slip11

# ---- New Cell ----

#slip17
same as slip1

# ---- New Cell ----

#slip18
same as slip3

# ---- New Cell ----

#slip19
same as slip4

# ---- New Cell ----

#slip20
same as slip10