# images-for-pray-emm-
   简单的java小程序，将一张图片改为由字符串组成的图。（英文很渣请无视库名。。。）

# Python实现
   本来写这个小程序就是刷知乎时看到有人用Python写。并且查了很多相关代码，感觉Python写出来效果也会比Java好（可能没找到好的Java代码）。整体代码很简单，参考了dalao的代码，百度了色彩方面的知识勉强写了。

# 关于色彩
   由于不了解三原色哪方面的东西，全凭刚搜索的知识，所以也是对RGB、灰度有一些理论上的了解，代码中灰度的计算以及分解都是网上找的算法。

# 怎么用？
   代码中Main类中的静态方法create的形参就是原图片的路径，由于也是随便写的代码自己玩，也不管用户之类的。。所以图片的路径随便改，相对路径绝对路径都无所谓，提供测试同时上传了test.jpg图，路径是相对路径。创建一个文本文件，将输出结果全选后粘贴过去，由于将像素级的图转换为字符组成，所以图是比原图大的，一般将记事本放大后可以看全图。同上原因，需要将得到的图放大或者缩小，将代码中2个for循环那里，x、y值的增加量调整即可。增量越大，得到的图越小。
# 关于生成的图片效果问题
   感觉效果不是特别好，感觉与色彩处理的算法、生成所用的字符都有关系，如果有dalao看到能指点一下不胜感激！
