# SortUsingArrayPattern

An algorithm that figures out and analyses the pattern of an array and then go for the best sorting algorithm possible for the array.

**Objective**<br>
When it comes to sorting an array, we have many different algorithms to choose from but which algorithm to choose for a particular situation, to get optimal performance, depends on the input data for that situation.<br/>
Imagine an algorithm that takes an array as input, analyses it and figures out the best sorting algorithm for it. Yeah! We did the same in this project so that you need not care about choose the right algorithm for optimal performance anymore.

<table>
  <tr>
    <th>Pattern</th>
    <th>Description</th>
    <th>Sort Algorithm</th>
  </tr>
  <tr>
    <td>Repeated</td>
    <td>Array containing many repeated elements.</td>
    <td>Count Sort</td>
  </tr>
  <tr>
    <td>Nearly Sorted</td>
    <td>Array is mostly in ascending order.</td>
    <td>Insertion Sort</td>
  </tr>
  <tr>
    <td>Nearly Reversed</td>
    <td>Array is mostly in descending order.</td>
    <td>Heap Sort</td>
  </tr>
  <tr>
    <td>Random</td>
    <td>Array in random pattern or if the pattern doesn’t match with any of the above.</td>
    <td>Quick Sort</td>
  </tr>
</table>

<b>Technique Used - Random Sampling:</b><br/>
In this method, we give priority to performance over accuracy. However, we were still able to achieve 96.4% success rate with this method. Here, we randomly pick few elements from the array in the increasing order of the index and give scores for each of the four patterns. The pattern with highest score at the end is taken as the array pattern. The number of elements to be sampled is given by the formula <b><i>log2n sets, each of size log5n.</i></b>
<table>
<tr><th>Array Size</th><th>Actual Pattern</th><th>Predicted Pattern</th><th>Sampled Size</th><th>Repeated Score</th><th>Reverse Score</th><th>Nearly Sorted Score</th><th>Random Score</th><th>Time Taken</th></tr>
<tr><td>50000</td><td>Repeated</td><td>Repeated</td><td>112</td><td>138</td><td>60</td><td>51</td><td>73</td><td>13299259</td></tr>
<tr><td>50000</td><td>Reverse</td><td>Reverse</td><td>112</td><td>0</td><td>112</td><td>-1</td><td>1</td><td>4342272</td></tr>
<tr><td>50000</td><td>Nearly Sorted</td><td>Nearly Sorted</td><td>112</td><td>0</td><td>-1</td><td>112</td><td>1</td><td>2139414</td></tr>
<tr><td>50000</td><td>Random</td><td>Random</td><td>112</td><td>0</td><td>64</td><td>47</td><td>72</td><td>4027845</td></tr>
<tr><td>50000</td><td>Repeated</td><td>Repeated</td><td>112</td><td>164</td><td>59</td><td>52</td><td>74</td><td>21102568</td></tr>
<tr><td>50000</td><td>Reverse</td><td>Reverse</td><td>112</td><td>0</td><td>111</td><td>0</td><td>3</td><td>3830045</td></tr>
<tr><td>50000</td><td>Nearly Sorted</td><td>Nearly Sorted</td><td>112</td><td>0</td><td>1</td><td>110</td><td>5</td><td>1021657</td></tr>
<tr><td>50000</td><td>Random</td><td>Random</td><td>112</td><td>0</td><td>57</td><td>54</td><td>71</td><td>1723754</td></tr>
<tr><td>50000</td><td>Repeated</td><td>Repeated</td><td>112</td><td>79</td><td>52</td><td>59</td><td>76</td><td>8487678</td></tr>
<tr><td>50000</td><td>Reverse</td><td>Reverse</td><td>112</td><td>0</td><td>110</td><td>1</td><td>5</td><td>3957402</td></tr>
<tr><td>50000</td><td>Nearly Sorted</td><td>Nearly Sorted</td><td>112</td><td>0</td><td>-1</td><td>112</td><td>1</td><td>1111693</td></tr>
<tr><td>50000</td><td>Random</td><td>Random</td><td>112</td><td>0</td><td>54</td><td>57</td><td>79</td><td>2218720</td></tr>
<tr><td>200000</td><td>Repeated</td><td>Repeated</td><td>144</td><td>136</td><td>74</td><td>69</td><td>97</td><td>14832677</td></tr>
<tr><td>200000</td><td>Reverse</td><td>Reverse</td><td>144</td><td>0</td><td>144</td><td>-1</td><td>1</td><td>2772467</td></tr>
<tr><td>200000</td><td>Nearly Sorted</td><td>Nearly Sorted</td><td>144</td><td>0</td><td>-1</td><td>144</td><td>1</td><td>1833383</td></tr>
<tr><td>200000</td><td>Random</td><td>Random</td><td>144</td><td>0</td><td>67</td><td>76</td><td>93</td><td>1575403</td></tr>
<tr><td>5000</td><td>Repeated</td><td>Repeated</td><td>78</td><td>122</td><td>41</td><td>36</td><td>55</td><td>9144990</td></tr>
<tr><td>5000</td><td>Reverse</td><td>Reverse</td><td>78</td><td>0</td><td>76</td><td>1</td><td>5</td><td>1162543</td></tr>
<tr><td>5000</td><td>Nearly Sorted</td><td>Nearly Sorted</td><td>78</td><td>0</td><td>-1</td><td>78</td><td>1</td><td>1148080</td></tr>
<tr><td>5000</td><td>Random</td><td>Random</td><td>78</td><td>0</td><td>41</td><td>36</td><td>44</td><td>1253978</td></tr>
<tr><td>5000</td><td>Repeated</td><td>Repeated</td><td>78</td><td>78</td><td>35</td><td>42</td><td>50</td><td>6224173</td></tr>
<tr><td>5000</td><td>Reverse</td><td>Reverse</td><td>78</td><td>0</td><td>75</td><td>2</td><td>7</td><td>805662</td></tr>
<tr><td>5000</td><td>Nearly Sorted</td><td>Nearly Sorted</td><td>78</td><td>0</td><td>0</td><td>77</td><td>3</td><td>756212</td></tr>
<tr><td>5000</td><td>Random</td><td>Random</td><td>78</td><td>0</td><td>39</td><td>38</td><td>54</td><td>877971</td></tr>
<tr><td>5000</td><td>Repeated</td><td>Repeated</td><td>78</td><td>122</td><td>44</td><td>33</td><td>57</td><td>7720736</td></tr>
<tr><td>5000</td><td>Reverse</td><td>Reverse</td><td>78</td><td>0</td><td>73</td><td>4</td><td>11</td><td>868174</td></tr>
<tr><td>5000</td><td>Nearly Sorted</td><td>Nearly Sorted</td><td>78</td><td>0</td><td>5</td><td>72</td><td>11</td><td>1114958</td></tr>
<tr><td>5000</td><td>Random</td><td>Random</td><td>78</td><td>0</td><td>38</td><td>39</td><td>54</td><td>1255844</td></tr>
<tr><td>1000</td><td>Repeated</td><td>Repeated</td><td>50</td><td>72</td><td>22</td><td>27</td><td>34</td><td>8849224</td></tr>
<tr><td>1000</td><td>Reverse</td><td>Reverse</td><td>50</td><td>0</td><td>44</td><td>5</td><td>13</td><td>773473</td></tr>
<tr><td>1000</td><td>Nearly Sorted</td><td>Nearly Sorted</td><td>50</td><td>18</td><td>8</td><td>41</td><td>17</td><td>1207794</td></tr>
<tr><td>1000</td><td>Random</td><td>Random</td><td>50</td><td>0</td><td>29</td><td>20</td><td>31</td><td>756679</td></tr>
<tr><td>1000</td><td>Repeated</td><td>Repeated</td><td>50</td><td>90</td><td>30</td><td>19</td><td>32</td><td>5835103</td></tr>
<tr><td>1000</td><td>Reverse</td><td>Reverse</td><td>50</td><td>0</td><td>46</td><td>3</td><td>9</td><td>447382</td></tr>
<tr><td>1000</td><td>Nearly Sorted</td><td>Nearly Sorted</td><td>50</td><td>0</td><td>6</td><td>43</td><td>10</td><td>472574</td></tr>
<tr><td>1000</td><td>Random</td><td>Random</td><td>50</td><td>9</td><td>22</td><td>27</td><td>36</td><td>508963</td></tr>
<tr><td>1000</td><td>Repeated</td><td>Repeated</td><td>50</td><td>95</td><td>26</td><td>23</td><td>31</td><td>7780916</td></tr>
<tr><td>1000</td><td>Reverse</td><td>Reverse</td><td>50</td><td>0</td><td>48</td><td>1</td><td>5</td><td>770208</td></tr>
<tr><td>1000</td><td>Nearly Sorted</td><td>Nearly Sorted</td><td>50</td><td>0</td><td>2</td><td>47</td><td>7</td><td>647982</td></tr>
<tr><td>1000</td><td>Random</td><td>Random</td><td>50</td><td>0</td><td>23</td><td>26</td><td>35</td><td>773473</td></tr>
<tr><td>100</td><td>Repeated</td><td>Repeated</td><td>21</td><td>38</td><td>12</td><td>8</td><td>15</td><td>7350328</td></tr>
<tr><td>100</td><td>Reverse</td><td>Reverse</td><td>21</td><td>0</td><td>13</td><td>7</td><td>11</td><td>313028</td></tr>
<tr><td>100</td><td>Nearly Sorted</td><td>Nearly Sorted</td><td>21</td><td>0</td><td>2</td><td>18</td><td>7</td><td>249582</td></tr>
<tr><td>100</td><td>Random</td><td>Random</td><td>21</td><td>5</td><td>11</td><td>9</td><td>14</td><td>431055</td></tr>
<tr><td>100</td><td>Repeated</td><td>Repeated</td><td>21</td><td>136</td><td>8</td><td>12</td><td>10</td><td>5614911</td></tr>
<tr><td>100</td><td>Reverse</td><td>Reverse</td><td>21</td><td>0</td><td>18</td><td>2</td><td>7</td><td>380672</td></tr>
<tr><td>100</td><td>Nearly Sorted</td><td>Nearly Sorted</td><td>21</td><td>0</td><td>4</td><td>16</td><td>6</td><td>366677</td></tr>
<tr><td>100</td><td>Random</td><td>Random</td><td>21</td><td>5</td><td>12</td><td>8</td><td>17</td><td>444584</td></tr>
<tr><td>60</td><td>Repeated</td><td>Repeated</td><td>18</td><td>87</td><td>7</td><td>10</td><td>12</td><td>5831372</td></tr>
<tr><td>60</td><td>Reverse</td><td>Repeated</td><td>18</td><td>15</td><td>11</td><td>6</td><td>10</td><td>269643</td></tr>
<tr><td>60</td><td>Nearly Sorted</td><td>Nearly Sorted</td><td>18</td><td>0</td><td>5</td><td>12</td><td>11</td><td>221125</td></tr>
<tr><td>60</td><td>Random</td><td>Random</td><td>18</td><td>0</td><td>6</td><td>11</td><td>13</td><td>248183</td></tr>
<tr><td>60</td><td>Repeated</td><td>Repeated</td><td>18</td><td>99</td><td>6</td><td>11</td><td>9</td><td>6804045</td></tr>
<tr><td>60</td><td>Reverse</td><td>Reverse</td><td>18</td><td>5</td><td>14</td><td>3</td><td>9</td><td>281306</td></tr>
<tr><td>60</td><td>Nearly Sorted</td><td>Nearly Sorted</td><td>18</td><td>0</td><td>4</td><td>13</td><td>11</td><td>219259</td></tr>
<tr><td>60</td><td>Random</td><td>Reverse</td><td>18</td><td>0</td><td>9</td><td>8</td><td>8</td><td>243985</td></tr>
<tr><td>60</td><td>Repeated</td><td>Repeated</td><td>18</td><td>60</td><td>7</td><td>10</td><td>9</td><td>8722799</td></tr>
<tr><td>60</td><td>Reverse</td><td>Reverse</td><td>18</td><td>0</td><td>13</td><td>4</td><td>9</td><td>270576</td></tr>
<tr><td>60</td><td>Nearly Sorted</td><td>Nearly Sorted</td><td>18</td><td>0</td><td>2</td><td>15</td><td>7</td><td>253782</td></tr>
<tr><td>60</td><td>Random</td><td>Random</td><td>18</td><td>0</td><td>7</td><td>10</td><td>15</td><td>452981</td></tr>
</table>

<b>Note: </b> <i>The efficiency of this algorithm can be felt only if the array size is huge. For smaller sized arrays, performing sort directly without prediction is much faster. During our analysis, we felt the impact only when the array size is greater than 5000.</i>
