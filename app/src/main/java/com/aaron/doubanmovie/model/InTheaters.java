package com.aaron.doubanmovie.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Git on 2016/1/23.
 */
public class InTheaters {

    /**
     * count : 20
     * start : 0
     * total : 25
     * subjects : [{"rating":{"max":10,"average":7.6,"stars":"40","min":0},"genres":["剧情","传记","冒险"],"collect_count":17483,"casts":[{"avatars":{"small":"http://img6.douban.com/img/celebrity/small/3517.jpg","large":"http://img6.douban.com/img/celebrity/large/3517.jpg","medium":"http://img6.douban.com/img/celebrity/medium/3517.jpg"},"alt":"http://movie.douban.com/celebrity/1101703/","id":"1101703","name":"约瑟夫·高登-莱维特"},{"avatars":{"small":"http://img6.douban.com/img/celebrity/small/1374649659.58.jpg","large":"http://img6.douban.com/img/celebrity/large/1374649659.58.jpg","medium":"http://img6.douban.com/img/celebrity/medium/1374649659.58.jpg"},"alt":"http://movie.douban.com/celebrity/1054393/","id":"1054393","name":"本·金斯利"},{"avatars":{"small":"http://img6.douban.com/img/celebrity/small/1389083702.11.jpg","large":"http://img6.douban.com/img/celebrity/large/1389083702.11.jpg","medium":"http://img6.douban.com/img/celebrity/medium/1389083702.11.jpg"},"alt":"http://movie.douban.com/celebrity/1330092/","id":"1330092","name":"夏洛特·勒·邦"}],"title":"云中行走","original_title":"The Walk","subtype":"movie","directors":[{"avatars":{"small":"http://img6.douban.com/img/celebrity/small/505.jpg","large":"http://img6.douban.com/img/celebrity/large/505.jpg","medium":"http://img6.douban.com/img/celebrity/medium/505.jpg"},"alt":"http://movie.douban.com/celebrity/1053564/","id":"1053564","name":"罗伯特·泽米吉斯"}],"year":"2015","images":{"small":"http://img6.douban.com/view/movie_poster_cover/ipst/public/p2299209970.jpg","large":"http://img6.douban.com/view/movie_poster_cover/lpst/public/p2299209970.jpg","medium":"http://img6.douban.com/view/movie_poster_cover/spst/public/p2299209970.jpg"},"alt":"http://movie.douban.com/subject/25819229/","id":"25819229"},{"rating":{"max":10,"average":5.6,"stars":"30","min":0},"genres":["喜剧"],"collect_count":228,"casts":[{"avatars":{"small":"http://img6.douban.com/img/celebrity/small/1603.jpg","large":"http://img6.douban.com/img/celebrity/large/1603.jpg","medium":"http://img6.douban.com/img/celebrity/medium/1603.jpg"},"alt":"http://movie.douban.com/celebrity/1037098/","id":"1037098","name":"吴镇宇"},{"avatars":{"small":"http://img6.douban.com/img/celebrity/small/1365758880.69.jpg","large":"http://img6.douban.com/img/celebrity/large/1365758880.69.jpg","medium":"http://img6.douban.com/img/celebrity/medium/1365758880.69.jpg"},"alt":"http://movie.douban.com/celebrity/1323729/","id":"1323729","name":"江疏影"},{"avatars":{"small":"http://img6.douban.com/img/celebrity/small/1398052268.11.jpg","large":"http://img6.douban.com/img/celebrity/large/1398052268.11.jpg","medium":"http://img6.douban.com/img/celebrity/medium/1398052268.11.jpg"},"alt":"http://movie.douban.com/celebrity/1032940/","id":"1032940","name":"郑中基"}],"title":"恶人报喜","original_title":"惡人谷","subtype":"movie","directors":[{"avatars":{"small":"http://img6.douban.com/img/celebrity/small/1387511001.02.jpg","large":"http://img6.douban.com/img/celebrity/large/1387511001.02.jpg","medium":"http://img6.douban.com/img/celebrity/medium/1387511001.02.jpg"},"alt":"http://movie.douban.com/celebrity/1025526/","id":"1025526","name":"谷德昭"}],"year":"2016","images":{"small":"http://img6.douban.com/view/movie_poster_cover/ipst/public/p2311133581.jpg","large":"http://img6.douban.com/view/movie_poster_cover/lpst/public/p2311133581.jpg","medium":"http://img6.douban.com/view/movie_poster_cover/spst/public/p2311133581.jpg"},"alt":"http://movie.douban.com/subject/26219651/","id":"26219651"},{"rating":{"max":10,"average":6.5,"stars":"35","min":0},"genres":["喜剧","动画","冒险"],"collect_count":112,"casts":[{"avatars":{"small":"http://img6.douban.com/f/movie/ca527386eb8c4e325611e22dfcb04cc116d6b423/pics/movie/celebrity-default-small.png","large":"http://img6.douban.com/f/movie/63acc16ca6309ef191f0378faf793d1096a3e606/pics/movie/celebrity-default-large.png","medium":"http://img6.douban.com/f/movie/8dd0c794499fe925ae2ae89ee30cd225750457b4/pics/movie/celebrity-default-medium.png"},"alt":"http://movie.douban.com/celebrity/1354188/","id":"1354188","name":"赖虹宇"},{"avatars":{"small":"http://img6.douban.com/img/celebrity/small/36586.jpg","large":"http://img6.douban.com/img/celebrity/large/36586.jpg","medium":"http://img6.douban.com/img/celebrity/medium/36586.jpg"},"alt":"http://movie.douban.com/celebrity/1316493/","id":"1316493","name":"祖晴"},{"avatars":{"small":"http://img6.douban.com/f/movie/ca527386eb8c4e325611e22dfcb04cc116d6b423/pics/movie/celebrity-default-small.png","large":"http://img6.douban.com/f/movie/63acc16ca6309ef191f0378faf793d1096a3e606/pics/movie/celebrity-default-large.png","medium":"http://img6.douban.com/f/movie/8dd0c794499fe925ae2ae89ee30cd225750457b4/pics/movie/celebrity-default-medium.png"},"alt":"http://movie.douban.com/celebrity/1354189/","id":"1354189","name":"鞠月斌"}],"title":"果宝特攻之水果大逃亡","original_title":"果宝特攻之水果大逃亡","subtype":"movie","directors":[{"avatars":{"small":"http://img6.douban.com/f/movie/ca527386eb8c4e325611e22dfcb04cc116d6b423/pics/movie/celebrity-default-small.png","large":"http://img6.douban.com/f/movie/63acc16ca6309ef191f0378faf793d1096a3e606/pics/movie/celebrity-default-large.png","medium":"http://img6.douban.com/f/movie/8dd0c794499fe925ae2ae89ee30cd225750457b4/pics/movie/celebrity-default-medium.png"},"alt":"http://movie.douban.com/celebrity/1353662/","id":"1353662","name":"王巍"}],"year":"2016","images":{"small":"http://img6.douban.com/view/movie_poster_cover/ipst/public/p2312396187.jpg","large":"http://img6.douban.com/view/movie_poster_cover/lpst/public/p2312396187.jpg","medium":"http://img6.douban.com/view/movie_poster_cover/spst/public/p2312396187.jpg"},"alt":"http://movie.douban.com/subject/26290381/","id":"26290381"},{"rating":{"max":10,"average":0,"stars":"00","min":0},"genres":["喜剧","动画","冒险"],"collect_count":138,"casts":[{"avatars":{"small":"http://img6.douban.com/f/movie/ca527386eb8c4e325611e22dfcb04cc116d6b423/pics/movie/celebrity-default-small.png","large":"http://img6.douban.com/f/movie/63acc16ca6309ef191f0378faf793d1096a3e606/pics/movie/celebrity-default-large.png","medium":"http://img6.douban.com/f/movie/8dd0c794499fe925ae2ae89ee30cd225750457b4/pics/movie/celebrity-default-medium.png"},"alt":"http://movie.douban.com/celebrity/1354198/","id":"1354198","name":"吕佩玉"},{"avatars":{"small":"http://img6.douban.com/f/movie/ca527386eb8c4e325611e22dfcb04cc116d6b423/pics/movie/celebrity-default-small.png","large":"http://img6.douban.com/f/movie/63acc16ca6309ef191f0378faf793d1096a3e606/pics/movie/celebrity-default-large.png","medium":"http://img6.douban.com/f/movie/8dd0c794499fe925ae2ae89ee30cd225750457b4/pics/movie/celebrity-default-medium.png"},"alt":"http://movie.douban.com/celebrity/1354200/","id":"1354200","name":"骆妍倩"},{"avatars":{"small":"http://img6.douban.com/f/movie/ca527386eb8c4e325611e22dfcb04cc116d6b423/pics/movie/celebrity-default-small.png","large":"http://img6.douban.com/f/movie/63acc16ca6309ef191f0378faf793d1096a3e606/pics/movie/celebrity-default-large.png","medium":"http://img6.douban.com/f/movie/8dd0c794499fe925ae2ae89ee30cd225750457b4/pics/movie/celebrity-default-medium.png"},"alt":"http://movie.douban.com/celebrity/1354199/","id":"1354199","name":"王愫稣"}],"title":"猿创世界之熊孩子部落","original_title":"猿创世界之熊孩子部落","subtype":"movie","directors":[{"avatars":{"small":"http://img6.douban.com/f/movie/ca527386eb8c4e325611e22dfcb04cc116d6b423/pics/movie/celebrity-default-small.png","large":"http://img6.douban.com/f/movie/63acc16ca6309ef191f0378faf793d1096a3e606/pics/movie/celebrity-default-large.png","medium":"http://img6.douban.com/f/movie/8dd0c794499fe925ae2ae89ee30cd225750457b4/pics/movie/celebrity-default-medium.png"},"alt":"http://movie.douban.com/celebrity/1354196/","id":"1354196","name":"刘潘"}],"year":"2016","images":{"small":"http://img6.douban.com/view/movie_poster_cover/ipst/public/p2309321568.jpg","large":"http://img6.douban.com/view/movie_poster_cover/lpst/public/p2309321568.jpg","medium":"http://img6.douban.com/view/movie_poster_cover/spst/public/p2309321568.jpg"},"alt":"http://movie.douban.com/subject/26688299/","id":"26688299"},{"rating":{"max":10,"average":7.3,"stars":"40","min":0},"genres":["动作","科幻","奇幻"],"collect_count":85561,"casts":[{"avatars":{"small":"http://img6.douban.com/img/celebrity/small/1398825610.2.jpg","large":"http://img6.douban.com/img/celebrity/large/1398825610.2.jpg","medium":"http://img6.douban.com/img/celebrity/medium/1398825610.2.jpg"},"alt":"http://movie.douban.com/celebrity/1339916/","id":"1339916","name":"黛西·雷德利"},{"avatars":{"small":"http://img6.douban.com/img/celebrity/small/53065.jpg","large":"http://img6.douban.com/img/celebrity/large/53065.jpg","medium":"http://img6.douban.com/img/celebrity/medium/53065.jpg"},"alt":"http://movie.douban.com/celebrity/1322327/","id":"1322327","name":"亚当·德赖弗"},{"avatars":{"small":"http://img6.douban.com/img/celebrity/small/23541.jpg","large":"http://img6.douban.com/img/celebrity/large/23541.jpg","medium":"http://img6.douban.com/img/celebrity/medium/23541.jpg"},"alt":"http://movie.douban.com/celebrity/1009238/","id":"1009238","name":"哈里森·福特"}],"title":"星球大战：原力觉醒","original_title":"Star Wars: The Force Awakens","subtype":"movie","directors":[{"avatars":{"small":"http://img6.douban.com/img/celebrity/small/1779.jpg","large":"http://img6.douban.com/img/celebrity/large/1779.jpg","medium":"http://img6.douban.com/img/celebrity/medium/1779.jpg"},"alt":"http://movie.douban.com/celebrity/1010542/","id":"1010542","name":"J·J·艾布拉姆斯"}],"year":"2015","images":{"small":"http://img6.douban.com/view/movie_poster_cover/ipst/public/p2293954118.jpg","large":"http://img6.douban.com/view/movie_poster_cover/lpst/public/p2293954118.jpg","medium":"http://img6.douban.com/view/movie_poster_cover/spst/public/p2293954118.jpg"},"alt":"http://movie.douban.com/subject/20326665/","id":"20326665"},{"rating":{"max":10,"average":6.1,"stars":"30","min":0},"genres":["犯罪","悬疑"],"collect_count":1532,"casts":[{"avatars":{"small":"http://img6.douban.com/img/celebrity/small/32971.jpg","large":"http://img6.douban.com/img/celebrity/large/32971.jpg","medium":"http://img6.douban.com/img/celebrity/medium/32971.jpg"},"alt":"http://movie.douban.com/celebrity/1031194/","id":"1031194","name":"任达华"},{"avatars":{"small":"http://img6.douban.com/img/celebrity/small/1414655610.66.jpg","large":"http://img6.douban.com/img/celebrity/large/1414655610.66.jpg","medium":"http://img6.douban.com/img/celebrity/medium/1414655610.66.jpg"},"alt":"http://movie.douban.com/celebrity/1015713/","id":"1015713","name":"霍建华"},{"avatars":{"small":"http://img6.douban.com/img/celebrity/small/25841.jpg","large":"http://img6.douban.com/img/celebrity/large/25841.jpg","medium":"http://img6.douban.com/img/celebrity/medium/25841.jpg"},"alt":"http://movie.douban.com/celebrity/1037420/","id":"1037420","name":"张赫"}],"title":"真相禁区","original_title":"真相禁区","subtype":"movie","directors":[{"avatars":{"small":"http://img6.douban.com/img/celebrity/small/1380274419.77.jpg","large":"http://img6.douban.com/img/celebrity/large/1380274419.77.jpg","medium":"http://img6.douban.com/img/celebrity/medium/1380274419.77.jpg"},"alt":"http://movie.douban.com/celebrity/1320018/","id":"1320018","name":"麦咏麟"}],"year":"2016","images":{"small":"http://img6.douban.com/view/movie_poster_cover/ipst/public/p2312467173.jpg","large":"http://img6.douban.com/view/movie_poster_cover/lpst/public/p2312467173.jpg","medium":"http://img6.douban.com/view/movie_poster_cover/spst/public/p2312467173.jpg"},"alt":"http://movie.douban.com/subject/26348798/","id":"26348798"},{"rating":{"max":10,"average":5.8,"stars":"30","min":0},"genres":["动作","奇幻","冒险"],"collect_count":12873,"casts":[{"avatars":{"small":"http://img6.douban.com/img/celebrity/small/53186.jpg","large":"http://img6.douban.com/img/celebrity/large/53186.jpg","medium":"http://img6.douban.com/img/celebrity/medium/53186.jpg"},"alt":"http://movie.douban.com/celebrity/1041020/","id":"1041020","name":"范·迪塞尔"},{"avatars":{"small":"http://img6.douban.com/img/celebrity/small/51597.jpg","large":"http://img6.douban.com/img/celebrity/large/51597.jpg","medium":"http://img6.douban.com/img/celebrity/medium/51597.jpg"},"alt":"http://movie.douban.com/celebrity/1054395/","id":"1054395","name":"伊利亚·伍德"},{"avatars":{"small":"http://img6.douban.com/img/celebrity/small/58460.jpg","large":"http://img6.douban.com/img/celebrity/large/58460.jpg","medium":"http://img6.douban.com/img/celebrity/medium/58460.jpg"},"alt":"http://movie.douban.com/celebrity/1265420/","id":"1265420","name":"露丝·莱斯利"}],"title":"最后的巫师猎人","original_title":"The Last Witch Hunter","subtype":"movie","directors":[{"avatars":{"small":"http://img6.douban.com/img/celebrity/small/1447589132.81.jpg","large":"http://img6.douban.com/img/celebrity/large/1447589132.81.jpg","medium":"http://img6.douban.com/img/celebrity/medium/1447589132.81.jpg"},"alt":"http://movie.douban.com/celebrity/1014076/","id":"1014076","name":"布瑞克·埃斯纳尔"}],"year":"2015","images":{"small":"http://img6.douban.com/view/movie_poster_cover/ipst/public/p2305094811.jpg","large":"http://img6.douban.com/view/movie_poster_cover/lpst/public/p2305094811.jpg","medium":"http://img6.douban.com/view/movie_poster_cover/spst/public/p2305094811.jpg"},"alt":"http://movie.douban.com/subject/10440076/","id":"10440076"},{"rating":{"max":10,"average":6.6,"stars":"35","min":0},"genres":["喜剧","动画","冒险"],"collect_count":1530,"casts":[{"avatars":{"small":"http://img6.douban.com/img/celebrity/small/1451196460.57.jpg","large":"http://img6.douban.com/img/celebrity/large/1451196460.57.jpg","medium":"http://img6.douban.com/img/celebrity/medium/1451196460.57.jpg"},"alt":"http://movie.douban.com/celebrity/1336920/","id":"1336920","name":"张伟"},{"avatars":{"small":"http://img6.douban.com/img/celebrity/small/1451196097.21.jpg","large":"http://img6.douban.com/img/celebrity/large/1451196097.21.jpg","medium":"http://img6.douban.com/img/celebrity/medium/1451196097.21.jpg"},"alt":"http://movie.douban.com/celebrity/1336919/","id":"1336919","name":"张秉君"},{"avatars":{"small":"http://img6.douban.com/f/movie/ca527386eb8c4e325611e22dfcb04cc116d6b423/pics/movie/celebrity-default-small.png","large":"http://img6.douban.com/f/movie/63acc16ca6309ef191f0378faf793d1096a3e606/pics/movie/celebrity-default-large.png","medium":"http://img6.douban.com/f/movie/8dd0c794499fe925ae2ae89ee30cd225750457b4/pics/movie/celebrity-default-medium.png"},"alt":"http://movie.douban.com/celebrity/1336930/","id":"1336930","name":"谭笑"}],"title":"熊出没之熊心归来","original_title":"熊出没之熊心归来","subtype":"movie","directors":[{"avatars":{"small":"http://img6.douban.com/img/celebrity/small/1451195637.94.jpg","large":"http://img6.douban.com/img/celebrity/large/1451195637.94.jpg","medium":"http://img6.douban.com/img/celebrity/medium/1451195637.94.jpg"},"alt":"http://movie.douban.com/celebrity/1336904/","id":"1336904","name":"丁亮"},{"avatars":{"small":"http://img6.douban.com/f/movie/ca527386eb8c4e325611e22dfcb04cc116d6b423/pics/movie/celebrity-default-small.png","large":"http://img6.douban.com/f/movie/63acc16ca6309ef191f0378faf793d1096a3e606/pics/movie/celebrity-default-large.png","medium":"http://img6.douban.com/f/movie/8dd0c794499fe925ae2ae89ee30cd225750457b4/pics/movie/celebrity-default-medium.png"},"alt":"http://movie.douban.com/celebrity/1352577/","id":"1352577","name":"林永长"}],"year":"2016","images":{"small":"http://img6.douban.com/view/movie_poster_cover/ipst/public/p2303088664.jpg","large":"http://img6.douban.com/view/movie_poster_cover/lpst/public/p2303088664.jpg","medium":"http://img6.douban.com/view/movie_poster_cover/spst/public/p2303088664.jpg"},"alt":"http://movie.douban.com/subject/26330955/","id":"26330955"},{"rating":{"max":10,"average":7.6,"stars":"40","min":0},"genres":["喜剧","动作","悬疑"],"collect_count":94913,"casts":[{"avatars":{"small":"http://img6.douban.com/img/celebrity/small/1356403251.95.jpg","large":"http://img6.douban.com/img/celebrity/large/1356403251.95.jpg","medium":"http://img6.douban.com/img/celebrity/medium/1356403251.95.jpg"},"alt":"http://movie.douban.com/celebrity/1274388/","id":"1274388","name":"王宝强"},{"avatars":{"small":"http://img6.douban.com/img/celebrity/small/1384938951.18.jpg","large":"http://img6.douban.com/img/celebrity/large/1384938951.18.jpg","medium":"http://img6.douban.com/img/celebrity/medium/1384938951.18.jpg"},"alt":"http://movie.douban.com/celebrity/1336305/","id":"1336305","name":"刘昊然"},{"avatars":{"small":"http://img6.douban.com/img/celebrity/small/12000.jpg","large":"http://img6.douban.com/img/celebrity/large/12000.jpg","medium":"http://img6.douban.com/img/celebrity/medium/12000.jpg"},"alt":"http://movie.douban.com/celebrity/1275756/","id":"1275756","name":"佟丽娅"}],"title":"唐人街探案","original_title":"唐人街探案","subtype":"movie","directors":[{"avatars":{"small":"http://img6.douban.com/img/celebrity/small/7957.jpg","large":"http://img6.douban.com/img/celebrity/large/7957.jpg","medium":"http://img6.douban.com/img/celebrity/medium/7957.jpg"},"alt":"http://movie.douban.com/celebrity/1274763/","id":"1274763","name":"陈思诚"}],"year":"2015","images":{"small":"http://img6.douban.com/view/movie_poster_cover/ipst/public/p2302930556.jpg","large":"http://img6.douban.com/view/movie_poster_cover/lpst/public/p2302930556.jpg","medium":"http://img6.douban.com/view/movie_poster_cover/spst/public/p2302930556.jpg"},"alt":"http://movie.douban.com/subject/26311973/","id":"26311973"},{"rating":{"max":10,"average":0,"stars":"00","min":0},"genres":["喜剧","动作","动画"],"collect_count":1408,"casts":[{"avatars":{"small":"http://img6.douban.com/img/celebrity/small/35722.jpg","large":"http://img6.douban.com/img/celebrity/large/35722.jpg","medium":"http://img6.douban.com/img/celebrity/medium/35722.jpg"},"alt":"http://movie.douban.com/celebrity/1049492/","id":"1049492","name":"杰克·布莱克"},{"avatars":{"small":"http://img6.douban.com/img/celebrity/small/50319.jpg","large":"http://img6.douban.com/img/celebrity/large/50319.jpg","medium":"http://img6.douban.com/img/celebrity/medium/50319.jpg"},"alt":"http://movie.douban.com/celebrity/1031807/","id":"1031807","name":"布莱恩·科兰斯顿"},{"avatars":{"small":"http://img6.douban.com/img/celebrity/small/604.jpg","large":"http://img6.douban.com/img/celebrity/large/604.jpg","medium":"http://img6.douban.com/img/celebrity/medium/604.jpg"},"alt":"http://movie.douban.com/celebrity/1054427/","id":"1054427","name":"达斯汀·霍夫曼"}],"title":"功夫熊猫3","original_title":"Kung Fu Panda 3","subtype":"movie","directors":[{"avatars":{"small":"http://img6.douban.com/img/celebrity/small/27153.jpg","large":"http://img6.douban.com/img/celebrity/large/27153.jpg","medium":"http://img6.douban.com/img/celebrity/medium/27153.jpg"},"alt":"http://movie.douban.com/celebrity/1301570/","id":"1301570","name":"吕寅荣"},{"avatars":{"small":"http://img6.douban.com/f/movie/ca527386eb8c4e325611e22dfcb04cc116d6b423/pics/movie/celebrity-default-small.png","large":"http://img6.douban.com/f/movie/63acc16ca6309ef191f0378faf793d1096a3e606/pics/movie/celebrity-default-large.png","medium":"http://img6.douban.com/f/movie/8dd0c794499fe925ae2ae89ee30cd225750457b4/pics/movie/celebrity-default-medium.png"},"alt":"http://movie.douban.com/celebrity/1351289/","id":"1351289","name":"亚历山德罗·卡罗尼"}],"year":"2016","images":{"small":"http://img6.douban.com/view/movie_poster_cover/ipst/public/p2306653420.jpg","large":"http://img6.douban.com/view/movie_poster_cover/lpst/public/p2306653420.jpg","medium":"http://img6.douban.com/view/movie_poster_cover/spst/public/p2306653420.jpg"},"alt":"http://movie.douban.com/subject/11589036/","id":"11589036"},{"rating":{"max":10,"average":8.4,"stars":"45","min":0},"genres":["剧情","动作","犯罪"],"collect_count":223762,"casts":[{"avatars":{"small":"http://img6.douban.com/img/celebrity/small/45667.jpg","large":"http://img6.douban.com/img/celebrity/large/45667.jpg","medium":"http://img6.douban.com/img/celebrity/medium/45667.jpg"},"alt":"http://movie.douban.com/celebrity/1274255/","id":"1274255","name":"冯小刚"},{"avatars":{"small":"http://img6.douban.com/img/celebrity/small/37882.jpg","large":"http://img6.douban.com/img/celebrity/large/37882.jpg","medium":"http://img6.douban.com/img/celebrity/medium/37882.jpg"},"alt":"http://movie.douban.com/celebrity/1005268/","id":"1005268","name":"许晴"},{"avatars":{"small":"http://img6.douban.com/img/celebrity/small/49047.jpg","large":"http://img6.douban.com/img/celebrity/large/49047.jpg","medium":"http://img6.douban.com/img/celebrity/medium/49047.jpg"},"alt":"http://movie.douban.com/celebrity/1274319/","id":"1274319","name":"张涵予"}],"title":"老炮儿","original_title":"老炮儿","subtype":"movie","directors":[{"avatars":{"small":"http://img6.douban.com/img/celebrity/small/8171.jpg","large":"http://img6.douban.com/img/celebrity/large/8171.jpg","medium":"http://img6.douban.com/img/celebrity/medium/8171.jpg"},"alt":"http://movie.douban.com/celebrity/1274919/","id":"1274919","name":"管虎"}],"year":"2015","images":{"small":"http://img6.douban.com/view/movie_poster_cover/ipst/public/p2292976849.jpg","large":"http://img6.douban.com/view/movie_poster_cover/lpst/public/p2292976849.jpg","medium":"http://img6.douban.com/view/movie_poster_cover/spst/public/p2292976849.jpg"},"alt":"http://movie.douban.com/subject/24751756/","id":"24751756"},{"rating":{"max":10,"average":7.9,"stars":"40","min":0},"genres":["剧情","动作","奇幻"],"collect_count":215249,"casts":[{"avatars":{"small":"http://img6.douban.com/img/celebrity/small/1327.jpg","large":"http://img6.douban.com/img/celebrity/large/1327.jpg","medium":"http://img6.douban.com/img/celebrity/medium/1327.jpg"},"alt":"http://movie.douban.com/celebrity/1053618/","id":"1053618","name":"陈坤"},{"avatars":{"small":"http://img6.douban.com/img/celebrity/small/1656.jpg","large":"http://img6.douban.com/img/celebrity/large/1656.jpg","medium":"http://img6.douban.com/img/celebrity/medium/1656.jpg"},"alt":"http://movie.douban.com/celebrity/1274242/","id":"1274242","name":"黄渤"},{"avatars":{"small":"http://img6.douban.com/img/celebrity/small/1268.jpg","large":"http://img6.douban.com/img/celebrity/large/1268.jpg","medium":"http://img6.douban.com/img/celebrity/medium/1268.jpg"},"alt":"http://movie.douban.com/celebrity/1138320/","id":"1138320","name":"舒淇"}],"title":"寻龙诀","original_title":"寻龙诀","subtype":"movie","directors":[{"avatars":{"small":"http://img6.douban.com/img/celebrity/small/1361431845.09.jpg","large":"http://img6.douban.com/img/celebrity/large/1361431845.09.jpg","medium":"http://img6.douban.com/img/celebrity/medium/1361431845.09.jpg"},"alt":"http://movie.douban.com/celebrity/1275211/","id":"1275211","name":"乌尔善"}],"year":"2015","images":{"small":"http://img6.douban.com/view/movie_poster_cover/ipst/public/p2284620292.jpg","large":"http://img6.douban.com/view/movie_poster_cover/lpst/public/p2284620292.jpg","medium":"http://img6.douban.com/view/movie_poster_cover/spst/public/p2284620292.jpg"},"alt":"http://movie.douban.com/subject/3077412/","id":"3077412"},{"rating":{"max":10,"average":4.6,"stars":"25","min":0},"genres":["喜剧","悬疑"],"collect_count":8211,"casts":[{"avatars":{"small":"http://img6.douban.com/img/celebrity/small/1656.jpg","large":"http://img6.douban.com/img/celebrity/large/1656.jpg","medium":"http://img6.douban.com/img/celebrity/medium/1656.jpg"},"alt":"http://movie.douban.com/celebrity/1274242/","id":"1274242","name":"黄渤"},{"avatars":{"small":"http://img6.douban.com/img/celebrity/small/24747.jpg","large":"http://img6.douban.com/img/celebrity/large/24747.jpg","medium":"http://img6.douban.com/img/celebrity/medium/24747.jpg"},"alt":"http://movie.douban.com/celebrity/1053581/","id":"1053581","name":"孙红雷"},{"avatars":{"small":"http://img6.douban.com/img/celebrity/small/20776.jpg","large":"http://img6.douban.com/img/celebrity/large/20776.jpg","medium":"http://img6.douban.com/img/celebrity/medium/20776.jpg"},"alt":"http://movie.douban.com/celebrity/1037715/","id":"1037715","name":"黄磊"}],"title":"极限挑战之皇家宝藏","original_title":"极限挑战之皇家宝藏","subtype":"movie","directors":[{"avatars":{"small":"http://img6.douban.com/img/celebrity/small/1452852234.33.jpg","large":"http://img6.douban.com/img/celebrity/large/1452852234.33.jpg","medium":"http://img6.douban.com/img/celebrity/medium/1452852234.33.jpg"},"alt":"http://movie.douban.com/celebrity/1351918/","id":"1351918","name":"任静"},{"avatars":{"small":"http://img6.douban.com/img/celebrity/small/1452852223.9.jpg","large":"http://img6.douban.com/img/celebrity/large/1452852223.9.jpg","medium":"http://img6.douban.com/img/celebrity/medium/1452852223.9.jpg"},"alt":"http://movie.douban.com/celebrity/1351917/","id":"1351917","name":"严敏"}],"year":"2016","images":{"small":"http://img6.douban.com/view/movie_poster_cover/ipst/public/p2309603103.jpg","large":"http://img6.douban.com/view/movie_poster_cover/lpst/public/p2309603103.jpg","medium":"http://img6.douban.com/view/movie_poster_cover/spst/public/p2309603103.jpg"},"alt":"http://movie.douban.com/subject/26607739/","id":"26607739"},{"rating":{"max":10,"average":3.9,"stars":"20","min":0},"genres":["剧情","悬疑","恐怖"],"collect_count":163,"casts":[{"avatars":{"small":"http://img6.douban.com/img/celebrity/small/40360.jpg","large":"http://img6.douban.com/img/celebrity/large/40360.jpg","medium":"http://img6.douban.com/img/celebrity/medium/40360.jpg"},"alt":"http://movie.douban.com/celebrity/1037846/","id":"1037846","name":"莫少聪"},{"avatars":{"small":"http://img6.douban.com/img/celebrity/small/43334.jpg","large":"http://img6.douban.com/img/celebrity/large/43334.jpg","medium":"http://img6.douban.com/img/celebrity/medium/43334.jpg"},"alt":"http://movie.douban.com/celebrity/1317092/","id":"1317092","name":"朱珠"},{"avatars":{"small":"http://img6.douban.com/img/celebrity/small/44245.jpg","large":"http://img6.douban.com/img/celebrity/large/44245.jpg","medium":"http://img6.douban.com/img/celebrity/medium/44245.jpg"},"alt":"http://movie.douban.com/celebrity/1318735/","id":"1318735","name":"陈廷嘉"}],"title":"恶灵之门","original_title":"恶灵之门","subtype":"movie","directors":[{"avatars":{"small":"http://img6.douban.com/img/celebrity/small/1451286288.54.jpg","large":"http://img6.douban.com/img/celebrity/large/1451286288.54.jpg","medium":"http://img6.douban.com/img/celebrity/medium/1451286288.54.jpg"},"alt":"http://movie.douban.com/celebrity/1352793/","id":"1352793","name":"郭大雷"}],"year":"2015","images":{"small":"http://img6.douban.com/view/movie_poster_cover/ipst/public/p2305205560.jpg","large":"http://img6.douban.com/view/movie_poster_cover/lpst/public/p2305205560.jpg","medium":"http://img6.douban.com/view/movie_poster_cover/spst/public/p2305205560.jpg"},"alt":"http://movie.douban.com/subject/26661696/","id":"26661696"},{"rating":{"max":10,"average":7,"stars":"35","min":0},"genres":["剧情","犯罪","悬疑"],"collect_count":101038,"casts":[{"avatars":{"small":"http://img6.douban.com/img/celebrity/small/41072.jpg","large":"http://img6.douban.com/img/celebrity/large/41072.jpg","medium":"http://img6.douban.com/img/celebrity/medium/41072.jpg"},"alt":"http://movie.douban.com/celebrity/1009405/","id":"1009405","name":"本尼迪克特·康伯巴奇"},{"avatars":{"small":"http://img6.douban.com/img/celebrity/small/35443.jpg","large":"http://img6.douban.com/img/celebrity/large/35443.jpg","medium":"http://img6.douban.com/img/celebrity/medium/35443.jpg"},"alt":"http://movie.douban.com/celebrity/1049612/","id":"1049612","name":"马丁·弗瑞曼"},{"avatars":{"small":"http://img6.douban.com/img/celebrity/small/31440.jpg","large":"http://img6.douban.com/img/celebrity/large/31440.jpg","medium":"http://img6.douban.com/img/celebrity/medium/31440.jpg"},"alt":"http://movie.douban.com/celebrity/1160302/","id":"1160302","name":"尤娜·斯塔布斯"}],"title":"神探夏洛克","original_title":"Sherlock: The Abominable Bride","subtype":"movie","directors":[{"avatars":{"small":"http://img6.douban.com/f/movie/ca527386eb8c4e325611e22dfcb04cc116d6b423/pics/movie/celebrity-default-small.png","large":"http://img6.douban.com/f/movie/63acc16ca6309ef191f0378faf793d1096a3e606/pics/movie/celebrity-default-large.png","medium":"http://img6.douban.com/f/movie/8dd0c794499fe925ae2ae89ee30cd225750457b4/pics/movie/celebrity-default-medium.png"},"alt":"http://movie.douban.com/celebrity/1290655/","id":"1290655","name":"道格拉斯·麦金农"}],"year":"2016","images":{"small":"http://img6.douban.com/view/movie_poster_cover/ipst/public/p2299823043.jpg","large":"http://img6.douban.com/view/movie_poster_cover/lpst/public/p2299823043.jpg","medium":"http://img6.douban.com/view/movie_poster_cover/spst/public/p2299823043.jpg"},"alt":"http://movie.douban.com/subject/25920885/","id":"25920885"},{"rating":{"max":10,"average":4.4,"stars":"25","min":0},"genres":["剧情","喜剧"],"collect_count":161,"casts":[{"avatars":{"small":"http://img6.douban.com/img/celebrity/small/1371009016.46.jpg","large":"http://img6.douban.com/img/celebrity/large/1371009016.46.jpg","medium":"http://img6.douban.com/img/celebrity/medium/1371009016.46.jpg"},"alt":"http://movie.douban.com/celebrity/1329906/","id":"1329906","name":"彭宇"},{"avatars":{"small":"http://img6.douban.com/img/celebrity/small/39129.jpg","large":"http://img6.douban.com/img/celebrity/large/39129.jpg","medium":"http://img6.douban.com/img/celebrity/medium/39129.jpg"},"alt":"http://movie.douban.com/celebrity/1312846/","id":"1312846","name":"柳岩"},{"avatars":{"small":"http://img6.douban.com/img/celebrity/small/1356505647.48.jpg","large":"http://img6.douban.com/img/celebrity/large/1356505647.48.jpg","medium":"http://img6.douban.com/img/celebrity/medium/1356505647.48.jpg"},"alt":"http://movie.douban.com/celebrity/1313024/","id":"1313024","name":"杜海涛"}],"title":"一家老小向前冲","original_title":"一家老小向前冲","subtype":"movie","directors":[{"avatars":{"small":"http://img6.douban.com/img/celebrity/small/6434.jpg","large":"http://img6.douban.com/img/celebrity/large/6434.jpg","medium":"http://img6.douban.com/img/celebrity/medium/6434.jpg"},"alt":"http://movie.douban.com/celebrity/1274778/","id":"1274778","name":"李平"}],"year":"2015","images":{"small":"http://img6.douban.com/view/movie_poster_cover/ipst/public/p2312385976.jpg","large":"http://img6.douban.com/view/movie_poster_cover/lpst/public/p2312385976.jpg","medium":"http://img6.douban.com/view/movie_poster_cover/spst/public/p2312385976.jpg"},"alt":"http://movie.douban.com/subject/26630517/","id":"26630517"},{"rating":{"max":10,"average":6.3,"stars":"35","min":0},"genres":["科幻","犯罪","悬疑"],"collect_count":9171,"casts":[{"avatars":{"small":"http://img6.douban.com/img/celebrity/small/19182.jpg","large":"http://img6.douban.com/img/celebrity/large/19182.jpg","medium":"http://img6.douban.com/img/celebrity/medium/19182.jpg"},"alt":"http://movie.douban.com/celebrity/1054434/","id":"1054434","name":"安东尼·霍普金斯"},{"avatars":{"small":"http://img6.douban.com/img/celebrity/small/724.jpg","large":"http://img6.douban.com/img/celebrity/large/724.jpg","medium":"http://img6.douban.com/img/celebrity/medium/724.jpg"},"alt":"http://movie.douban.com/celebrity/1084255/","id":"1084255","name":"科林·法瑞尔"},{"avatars":{"small":"http://img6.douban.com/img/celebrity/small/6531.jpg","large":"http://img6.douban.com/img/celebrity/large/6531.jpg","medium":"http://img6.douban.com/img/celebrity/medium/6531.jpg"},"alt":"http://movie.douban.com/celebrity/1044708/","id":"1044708","name":"杰弗里·迪恩·摩根"}],"title":"通灵神探","original_title":"Solace","subtype":"movie","directors":[{"avatars":{"small":"http://img6.douban.com/img/celebrity/small/1450764958.43.jpg","large":"http://img6.douban.com/img/celebrity/large/1450764958.43.jpg","medium":"http://img6.douban.com/img/celebrity/medium/1450764958.43.jpg"},"alt":"http://movie.douban.com/celebrity/1353608/","id":"1353608","name":"阿方索·博亚尔特"}],"year":"2015","images":{"small":"http://img6.douban.com/view/movie_poster_cover/ipst/public/p2300255376.jpg","large":"http://img6.douban.com/view/movie_poster_cover/lpst/public/p2300255376.jpg","medium":"http://img6.douban.com/view/movie_poster_cover/spst/public/p2300255376.jpg"},"alt":"http://movie.douban.com/subject/3217142/","id":"3217142"},{"rating":{"max":10,"average":0,"stars":"00","min":0},"genres":["爱情"],"collect_count":43,"casts":[{"avatars":{"small":"http://img6.douban.com/img/celebrity/small/26564.jpg","large":"http://img6.douban.com/img/celebrity/large/26564.jpg","medium":"http://img6.douban.com/img/celebrity/medium/26564.jpg"},"alt":"http://movie.douban.com/celebrity/1023681/","id":"1023681","name":"温碧霞"},{"avatars":{"small":"http://img6.douban.com/img/celebrity/small/3285.jpg","large":"http://img6.douban.com/img/celebrity/large/3285.jpg","medium":"http://img6.douban.com/img/celebrity/medium/3285.jpg"},"alt":"http://movie.douban.com/celebrity/1033280/","id":"1033280","name":"谭耀文"},{"avatars":{"small":"http://img6.douban.com/img/celebrity/small/1361546333.62.jpg","large":"http://img6.douban.com/img/celebrity/large/1361546333.62.jpg","medium":"http://img6.douban.com/img/celebrity/medium/1361546333.62.jpg"},"alt":"http://movie.douban.com/celebrity/1326947/","id":"1326947","name":"赵炳锐"}],"title":"爱在深秋","original_title":"愛在深秋","subtype":"movie","directors":[{"avatars":{"small":"http://img6.douban.com/f/movie/ca527386eb8c4e325611e22dfcb04cc116d6b423/pics/movie/celebrity-default-small.png","large":"http://img6.douban.com/f/movie/63acc16ca6309ef191f0378faf793d1096a3e606/pics/movie/celebrity-default-large.png","medium":"http://img6.douban.com/f/movie/8dd0c794499fe925ae2ae89ee30cd225750457b4/pics/movie/celebrity-default-medium.png"},"alt":"http://movie.douban.com/celebrity/1275630/","id":"1275630","name":"林家威"}],"year":"2016","images":{"small":"http://img6.douban.com/view/movie_poster_cover/ipst/public/p2307821851.jpg","large":"http://img6.douban.com/view/movie_poster_cover/lpst/public/p2307821851.jpg","medium":"http://img6.douban.com/view/movie_poster_cover/spst/public/p2307821851.jpg"},"alt":"http://movie.douban.com/subject/26351519/","id":"26351519"},{"rating":{"max":10,"average":4.7,"stars":"25","min":0},"genres":["爱情","悬疑"],"collect_count":4655,"casts":[{"avatars":{"small":"http://img6.douban.com/img/celebrity/small/1503.jpg","large":"http://img6.douban.com/img/celebrity/large/1503.jpg","medium":"http://img6.douban.com/img/celebrity/medium/1503.jpg"},"alt":"http://movie.douban.com/celebrity/1036978/","id":"1036978","name":"黎明"},{"avatars":{"small":"http://img6.douban.com/img/celebrity/small/37672.jpg","large":"http://img6.douban.com/img/celebrity/large/37672.jpg","medium":"http://img6.douban.com/img/celebrity/medium/37672.jpg"},"alt":"http://movie.douban.com/celebrity/1274301/","id":"1274301","name":"王珞丹"},{"avatars":{"small":"http://img6.douban.com/img/celebrity/small/24491.jpg","large":"http://img6.douban.com/img/celebrity/large/24491.jpg","medium":"http://img6.douban.com/img/celebrity/medium/24491.jpg"},"alt":"http://movie.douban.com/celebrity/1313342/","id":"1313342","name":"林俊杰"}],"title":"消失爱人","original_title":"消失爱人","subtype":"movie","directors":[{"avatars":{"small":"http://img6.douban.com/img/celebrity/small/5139.jpg","large":"http://img6.douban.com/img/celebrity/large/5139.jpg","medium":"http://img6.douban.com/img/celebrity/medium/5139.jpg"},"alt":"http://movie.douban.com/celebrity/1274280/","id":"1274280","name":"黄真真"}],"year":"2016","images":{"small":"http://img6.douban.com/view/movie_poster_cover/ipst/public/p2305070844.jpg","large":"http://img6.douban.com/view/movie_poster_cover/lpst/public/p2305070844.jpg","medium":"http://img6.douban.com/view/movie_poster_cover/spst/public/p2305070844.jpg"},"alt":"http://movie.douban.com/subject/26309968/","id":"26309968"},{"rating":{"max":10,"average":5.7,"stars":"30","min":0},"genres":["喜剧","悬疑"],"collect_count":543,"casts":[{"avatars":{"small":"http://img6.douban.com/img/celebrity/small/1441793528.59.jpg","large":"http://img6.douban.com/img/celebrity/large/1441793528.59.jpg","medium":"http://img6.douban.com/img/celebrity/medium/1441793528.59.jpg"},"alt":"http://movie.douban.com/celebrity/1313285/","id":"1313285","name":"孙坚"},{"avatars":{"small":"http://img6.douban.com/img/celebrity/small/11386.jpg","large":"http://img6.douban.com/img/celebrity/large/11386.jpg","medium":"http://img6.douban.com/img/celebrity/medium/11386.jpg"},"alt":"http://movie.douban.com/celebrity/1275547/","id":"1275547","name":"白冰"},{"avatars":{"small":"http://img6.douban.com/img/celebrity/small/48498.jpg","large":"http://img6.douban.com/img/celebrity/large/48498.jpg","medium":"http://img6.douban.com/img/celebrity/medium/48498.jpg"},"alt":"http://movie.douban.com/celebrity/1275490/","id":"1275490","name":"潘霜霜"}],"title":"谎言大爆炸","original_title":"谎言大爆炸","subtype":"movie","directors":[{"avatars":{"small":"http://img6.douban.com/img/celebrity/small/22192.jpg","large":"http://img6.douban.com/img/celebrity/large/22192.jpg","medium":"http://img6.douban.com/img/celebrity/medium/22192.jpg"},"alt":"http://movie.douban.com/celebrity/1314175/","id":"1314175","name":"侯亮"}],"year":"2016","images":{"small":"http://img6.douban.com/view/movie_poster_cover/ipst/public/p2312339090.jpg","large":"http://img6.douban.com/view/movie_poster_cover/lpst/public/p2312339090.jpg","medium":"http://img6.douban.com/view/movie_poster_cover/spst/public/p2312339090.jpg"},"alt":"http://movie.douban.com/subject/26686170/","id":"26686170"}]
     * title : 正在上映的电影-北京
     */

    @SerializedName("count")
    private int mCount;
    @SerializedName("start")
    private int mStart;
    @SerializedName("total")
    private int mTotal;
    @SerializedName("title")
    private String mTitle;
    /**
     * rating : {"max":10,"average":7.6,"stars":"40","min":0}
     * genres : ["剧情","传记","冒险"]
     * collect_count : 17483
     * casts : [{"avatars":{"small":"http://img6.douban.com/img/celebrity/small/3517.jpg","large":"http://img6.douban.com/img/celebrity/large/3517.jpg","medium":"http://img6.douban.com/img/celebrity/medium/3517.jpg"},"alt":"http://movie.douban.com/celebrity/1101703/","id":"1101703","name":"约瑟夫·高登-莱维特"},{"avatars":{"small":"http://img6.douban.com/img/celebrity/small/1374649659.58.jpg","large":"http://img6.douban.com/img/celebrity/large/1374649659.58.jpg","medium":"http://img6.douban.com/img/celebrity/medium/1374649659.58.jpg"},"alt":"http://movie.douban.com/celebrity/1054393/","id":"1054393","name":"本·金斯利"},{"avatars":{"small":"http://img6.douban.com/img/celebrity/small/1389083702.11.jpg","large":"http://img6.douban.com/img/celebrity/large/1389083702.11.jpg","medium":"http://img6.douban.com/img/celebrity/medium/1389083702.11.jpg"},"alt":"http://movie.douban.com/celebrity/1330092/","id":"1330092","name":"夏洛特·勒·邦"}]
     * title : 云中行走
     * original_title : The Walk
     * subtype : movie
     * directors : [{"avatars":{"small":"http://img6.douban.com/img/celebrity/small/505.jpg","large":"http://img6.douban.com/img/celebrity/large/505.jpg","medium":"http://img6.douban.com/img/celebrity/medium/505.jpg"},"alt":"http://movie.douban.com/celebrity/1053564/","id":"1053564","name":"罗伯特·泽米吉斯"}]
     * year : 2015
     * images : {"small":"http://img6.douban.com/view/movie_poster_cover/ipst/public/p2299209970.jpg","large":"http://img6.douban.com/view/movie_poster_cover/lpst/public/p2299209970.jpg","medium":"http://img6.douban.com/view/movie_poster_cover/spst/public/p2299209970.jpg"}
     * alt : http://movie.douban.com/subject/25819229/
     * id : 25819229
     */

    @SerializedName("subjects")
    private List<Movie> mMovies;

    public void setCount(int count) {
        this.mCount = count;
    }

    public void setStart(int start) {
        this.mStart = start;
    }

    public void setTotal(int total) {
        this.mTotal = total;
    }

    public void setTitle(String title) {
        this.mTitle = title;
    }

    public void setMovies(List<Movie> movies) {
        this.mMovies = movies;
    }

    public int getCount() {
        return mCount;
    }

    public int getStart() {
        return mStart;
    }

    public int getTotal() {
        return mTotal;
    }

    public String getTitle() {
        return mTitle;
    }

    public List<Movie> getMovies() {
        return mMovies;
    }

    public static class Movie implements Parcelable {
        /**
         * max : 10
         * average : 7.6
         * stars : 40
         * min : 0
         */

        @SerializedName("rating")
        private Rating mRating;
        @SerializedName("collect_count")
        private int mCollectCount;
        @SerializedName("title")
        private String mTitle;
        @SerializedName("original_title")
        private String mOriginalTitle;
        @SerializedName("subtype")
        private String mSubtype;
        @SerializedName("year")
        private String mYear;
        /**
         * small : http://img6.douban.com/view/movie_poster_cover/ipst/public/p2299209970.jpg
         * large : http://img6.douban.com/view/movie_poster_cover/lpst/public/p2299209970.jpg
         * medium : http://img6.douban.com/view/movie_poster_cover/spst/public/p2299209970.jpg
         */

        @SerializedName("images")
        private Images mImages;
        @SerializedName("alt")
        private String mAlt;
        @SerializedName("id")
        private String mId;
        @SerializedName("genres")
        private List<String> mGenres;
        /**
         * avatars : {"small":"http://img6.douban.com/img/celebrity/small/3517.jpg","large":"http://img6.douban.com/img/celebrity/large/3517.jpg","medium":"http://img6.douban.com/img/celebrity/medium/3517.jpg"}
         * alt : http://movie.douban.com/celebrity/1101703/
         * id : 1101703
         * name : 约瑟夫·高登-莱维特
         */

        @SerializedName("casts")
        private List<Cast> mCasts;
        /**
         * avatars : {"small":"http://img6.douban.com/img/celebrity/small/505.jpg","large":"http://img6.douban.com/img/celebrity/large/505.jpg","medium":"http://img6.douban.com/img/celebrity/medium/505.jpg"}
         * alt : http://movie.douban.com/celebrity/1053564/
         * id : 1053564
         * name : 罗伯特·泽米吉斯
         */

        @SerializedName("directors")
        private List<Director> mDirectors;

        public void setRating(Rating rating) {
            this.mRating = rating;
        }

        public void setCollectCount(int collectCount) {
            this.mCollectCount = collectCount;
        }

        public void setTitle(String title) {
            this.mTitle = title;
        }

        public void setOriginalTitle(String originalTitle) {
            this.mOriginalTitle = originalTitle;
        }

        public void setSubtype(String subtype) {
            this.mSubtype = subtype;
        }

        public void setYear(String year) {
            this.mYear = year;
        }

        public void setImages(Images images) {
            this.mImages = images;
        }

        public void setAlt(String alt) {
            this.mAlt = alt;
        }

        public void setId(String id) {
            this.mId = id;
        }

        public void setGenres(List<String> genres) {
            this.mGenres = genres;
        }

        public void setCasts(List<Cast> casts) {
            this.mCasts = casts;
        }

        public void setDirectors(List<Director> directors) {
            this.mDirectors = directors;
        }

        public Rating getRating() {
            return mRating;
        }

        public int getCollectCount() {
            return mCollectCount;
        }

        public String getTitle() {
            return mTitle;
        }

        public String getOriginalTitle() {
            return mOriginalTitle;
        }

        public String getSubtype() {
            return mSubtype;
        }

        public String getYear() {
            return mYear;
        }

        public Images getImages() {
            return mImages;
        }

        public String getAlt() {
            return mAlt;
        }

        public String getId() {
            return mId;
        }

        public List<String> getGenres() {
            return mGenres;
        }

        public List<Cast> getCasts() {
            return mCasts;
        }

        public List<Director> getDirectors() {
            return mDirectors;
        }

        public static class Rating {
            @SerializedName("max")
            private int mMax;
            @SerializedName("average")
            private double mAverage;
            @SerializedName("stars")
            private String mStars;
            @SerializedName("min")
            private int mMin;

            public void setMax(int max) {
                this.mMax = max;
            }

            public void setAverage(double average) {
                this.mAverage = average;
            }

            public void setStars(String stars) {
                this.mStars = stars;
            }

            public void setMin(int min) {
                this.mMin = min;
            }

            public int getMax() {
                return mMax;
            }

            public double getAverage() {
                return mAverage;
            }

            public String getStars() {
                return mStars;
            }

            public int getMin() {
                return mMin;
            }
        }

        public static class Images implements Parcelable {
            @SerializedName("small")
            private String mSmall;
            @SerializedName("large")
            private String mLarge;
            @SerializedName("medium")
            private String mMedium;

            public void setSmall(String small) {
                this.mSmall = small;
            }

            public void setLarge(String large) {
                this.mLarge = large;
            }

            public void setMedium(String medium) {
                this.mMedium = medium;
            }

            public String getSmall() {
                return mSmall;
            }

            public String getLarge() {
                return mLarge;
            }

            public String getMedium() {
                return mMedium;
            }

            @Override
            public int describeContents() {
                return 0;
            }

            @Override
            public void writeToParcel(Parcel dest, int flags) {
                dest.writeString(this.mSmall);
                dest.writeString(this.mLarge);
                dest.writeString(this.mMedium);
            }

            public Images() {
            }

            protected Images(Parcel in) {
                this.mSmall = in.readString();
                this.mLarge = in.readString();
                this.mMedium = in.readString();
            }

            public static final Creator<Images> CREATOR = new Creator<Images>() {
                public Images createFromParcel(Parcel source) {
                    return new Images(source);
                }

                public Images[] newArray(int size) {
                    return new Images[size];
                }
            };
        }

        public static class Cast implements Parcelable {
            /**
             * small : http://img6.douban.com/img/celebrity/small/3517.jpg
             * large : http://img6.douban.com/img/celebrity/large/3517.jpg
             * medium : http://img6.douban.com/img/celebrity/medium/3517.jpg
             */

            @SerializedName("avatars")
            private Avatars mAvatars;
            @SerializedName("alt")
            private String mAlt;
            @SerializedName("id")
            private String mId;
            @SerializedName("name")
            private String mName;

            public void setAvatars(Avatars avatars) {
                this.mAvatars = avatars;
            }

            public void setAlt(String alt) {
                this.mAlt = alt;
            }

            public void setId(String id) {
                this.mId = id;
            }

            public void setName(String name) {
                this.mName = name;
            }

            public Avatars getAvatars() {
                return mAvatars;
            }

            public String getAlt() {
                return mAlt;
            }

            public String getId() {
                return mId;
            }

            public String getName() {
                return mName;
            }

            public static class Avatars {
                @SerializedName("small")
                private String mSmall;
                @SerializedName("large")
                private String mLarge;
                @SerializedName("medium")
                private String mMedium;

                public void setSmall(String small) {
                    this.mSmall = small;
                }

                public void setLarge(String large) {
                    this.mLarge = large;
                }

                public void setMedium(String medium) {
                    this.mMedium = medium;
                }

                public String getSmall() {
                    return mSmall;
                }

                public String getLarge() {
                    return mLarge;
                }

                public String getMedium() {
                    return mMedium;
                }
            }

            @Override
            public int describeContents() {
                return 0;
            }

            @Override
            public void writeToParcel(Parcel dest, int flags) {
                dest.writeString(this.mName);
            }

            public Cast() {
            }

            protected Cast(Parcel in) {
                this.mName = in.readString();
            }

            public static final Creator<Cast> CREATOR = new Creator<Cast>() {
                public Cast createFromParcel(Parcel source) {
                    return new Cast(source);
                }

                public Cast[] newArray(int size) {
                    return new Cast[size];
                }
            };
        }

        public static class Director implements Parcelable {
            /**
             * small : http://img6.douban.com/img/celebrity/small/505.jpg
             * large : http://img6.douban.com/img/celebrity/large/505.jpg
             * medium : http://img6.douban.com/img/celebrity/medium/505.jpg
             */

            @SerializedName("avatars")
            private Avatars mAvatars;
            @SerializedName("alt")
            private String mAlt;
            @SerializedName("id")
            private String mId;
            @SerializedName("name")
            private String mName;

            public void setAvatars(Avatars avatars) {
                this.mAvatars = avatars;
            }

            public void setAlt(String alt) {
                this.mAlt = alt;
            }

            public void setId(String id) {
                this.mId = id;
            }

            public void setName(String name) {
                this.mName = name;
            }

            public Avatars getAvatars() {
                return mAvatars;
            }

            public String getAlt() {
                return mAlt;
            }

            public String getId() {
                return mId;
            }

            public String getName() {
                return mName;
            }

            public static class Avatars {
                @SerializedName("small")
                private String mSmall;
                @SerializedName("large")
                private String mLarge;
                @SerializedName("medium")
                private String mMedium;

                public void setSmall(String small) {
                    this.mSmall = small;
                }

                public void setLarge(String large) {
                    this.mLarge = large;
                }

                public void setMedium(String medium) {
                    this.mMedium = medium;
                }

                public String getSmall() {
                    return mSmall;
                }

                public String getLarge() {
                    return mLarge;
                }

                public String getMedium() {
                    return mMedium;
                }
            }

            @Override
            public int describeContents() {
                return 0;
            }

            @Override
            public void writeToParcel(Parcel dest, int flags) {
                dest.writeString(this.mName);
            }

            public Director() {
            }

            protected Director(Parcel in) {
                this.mName = in.readString();
            }

            public static final Creator<Director> CREATOR = new Creator<Director>() {
                public Director createFromParcel(Parcel source) {
                    return new Director(source);
                }

                public Director[] newArray(int size) {
                    return new Director[size];
                }
            };
        }

        public Movie() {
        }

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeString(this.mTitle);
            dest.writeParcelable(this.mImages, 0);
            dest.writeString(this.mId);
            dest.writeTypedList(mCasts);
            dest.writeTypedList(mDirectors);
        }

        protected Movie(Parcel in) {
            this.mTitle = in.readString();
            this.mImages = in.readParcelable(Images.class.getClassLoader());
            this.mId = in.readString();
            this.mCasts = in.createTypedArrayList(Cast.CREATOR);
            this.mDirectors = in.createTypedArrayList(Director.CREATOR);
        }

        public static final Creator<Movie> CREATOR = new Creator<Movie>() {
            public Movie createFromParcel(Parcel source) {
                return new Movie(source);
            }

            public Movie[] newArray(int size) {
                return new Movie[size];
            }
        };
    }
}
