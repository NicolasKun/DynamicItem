###InsertItem

##ListView动态插入条目

每个条目中包括EditText和Button
通过Button跳转到某个页面并将值返回填入相对应的EditText<完成>

EditText手动输入
并保存<未完成>
Bug : 当手动输入完成添加新条目数据被清空
      Button跳转也会出现数据填充错乱
      
目前做法:
```
    holder.etContent.setFocusable(false);
```