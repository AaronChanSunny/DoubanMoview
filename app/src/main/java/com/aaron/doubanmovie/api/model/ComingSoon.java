package com.aaron.doubanmovie.api.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by aaronchan on 16/4/30.
 */
public class ComingSoon {

    /**
     * count : 20
     * start : 0
     * total : 91
     * subjects : [{"rating":{"max":10,"average":0,"stars":"00","min":0},"genres":["剧情","儿童","爱情"],"title":"风铃上的卡片","casts":[{"alt":null,"avatars":null,"name":"李春丽","id":null},{"alt":null,"avatars":null,"name":"付诗雨","id":null},{"alt":null,"avatars":null,"name":"高仁会","id":null}],"collect_count":8,"original_title":"风铃上的卡片","subtype":"movie","directors":[{"alt":"https://movie.douban.com/celebrity/1335111/","avatars":{"small":"http://img3.douban.com/img/celebrity/small/1383666301.95.jpg","large":"http://img3.douban.com/img/celebrity/large/1383666301.95.jpg","medium":"http://img3.douban.com/img/celebrity/medium/1383666301.95.jpg"},"name":"胡阳","id":"1335111"}],"year":"2015","images":{"small":"http://img3.douban.com/view/movie_poster_cover/ipst/public/p2328692972.jpg","large":"http://img3.douban.com/view/movie_poster_cover/lpst/public/p2328692972.jpg","medium":"http://img3.douban.com/view/movie_poster_cover/spst/public/p2328692972.jpg"},"alt":"https://movie.douban.com/subject/26765192/","id":"26765192"},{"rating":{"max":10,"average":0,"stars":"00","min":0},"genres":["动作","科幻","冒险"],"title":"美国队长3","casts":[{"alt":"https://movie.douban.com/celebrity/1017885/","avatars":{"small":"http://img3.doubanio.com/img/celebrity/small/1359877729.49.jpg","large":"http://img3.doubanio.com/img/celebrity/large/1359877729.49.jpg","medium":"http://img3.doubanio.com/img/celebrity/medium/1359877729.49.jpg"},"name":"克里斯·埃文斯","id":"1017885"},{"alt":"https://movie.douban.com/celebrity/1016681/","avatars":{"small":"http://img3.doubanio.com/img/celebrity/small/4938.jpg","large":"http://img3.doubanio.com/img/celebrity/large/4938.jpg","medium":"http://img3.doubanio.com/img/celebrity/medium/4938.jpg"},"name":"小罗伯特·唐尼","id":"1016681"},{"alt":"https://movie.douban.com/celebrity/1054453/","avatars":{"small":"http://img3.douban.com/img/celebrity/small/37050.jpg","large":"http://img3.douban.com/img/celebrity/large/37050.jpg","medium":"http://img3.douban.com/img/celebrity/medium/37050.jpg"},"name":"斯嘉丽·约翰逊","id":"1054453"}],"collect_count":2022,"original_title":"Captain America: Civil War","subtype":"movie","directors":[{"alt":"https://movie.douban.com/celebrity/1321812/","avatars":{"small":"http://img3.doubanio.com/img/celebrity/small/51466.jpg","large":"http://img3.doubanio.com/img/celebrity/large/51466.jpg","medium":"http://img3.doubanio.com/img/celebrity/medium/51466.jpg"},"name":"安东尼·卢素","id":"1321812"},{"alt":"https://movie.douban.com/celebrity/1320870/","avatars":{"small":"http://img3.douban.com/img/celebrity/small/49855.jpg","large":"http://img3.douban.com/img/celebrity/large/49855.jpg","medium":"http://img3.douban.com/img/celebrity/medium/49855.jpg"},"name":"乔·卢素","id":"1320870"}],"year":"2016","images":{"small":"http://img3.douban.com/view/movie_poster_cover/ipst/public/p2332092960.jpg","large":"http://img3.douban.com/view/movie_poster_cover/lpst/public/p2332092960.jpg","medium":"http://img3.douban.com/view/movie_poster_cover/spst/public/p2332092960.jpg"},"alt":"https://movie.douban.com/subject/25820460/","id":"25820460"},{"rating":{"max":10,"average":7.8,"stars":"40","min":0},"genres":["剧情"],"title":"百鸟朝凤","casts":[{"alt":"https://movie.douban.com/celebrity/1039767/","avatars":{"small":"http://img3.doubanio.com/img/celebrity/small/6619.jpg","large":"http://img3.doubanio.com/img/celebrity/large/6619.jpg","medium":"http://img3.doubanio.com/img/celebrity/medium/6619.jpg"},"name":"陶泽如","id":"1039767"},{"alt":"https://movie.douban.com/celebrity/1318702/","avatars":{"small":"http://img3.douban.com/img/celebrity/small/1398314807.63.jpg","large":"http://img3.douban.com/img/celebrity/large/1398314807.63.jpg","medium":"http://img3.douban.com/img/celebrity/medium/1398314807.63.jpg"},"name":"李岷城","id":"1318702"}],"collect_count":286,"original_title":"百鸟朝凤","subtype":"movie","directors":[{"alt":"https://movie.douban.com/celebrity/1168676/","avatars":{"small":"http://img3.doubanio.com/img/celebrity/small/6396.jpg","large":"http://img3.doubanio.com/img/celebrity/large/6396.jpg","medium":"http://img3.doubanio.com/img/celebrity/medium/6396.jpg"},"name":"吴天明","id":"1168676"}],"year":"2013","images":{"small":"http://img3.douban.com/view/movie_poster_cover/ipst/public/p2332714135.jpg","large":"http://img3.douban.com/view/movie_poster_cover/lpst/public/p2332714135.jpg","medium":"http://img3.douban.com/view/movie_poster_cover/spst/public/p2332714135.jpg"},"alt":"https://movie.douban.com/subject/10831445/","id":"10831445"},{"rating":{"max":10,"average":6.6,"stars":"35","min":0},"genres":["剧情","喜剧"],"title":"心在彼处","casts":[{"alt":"https://movie.douban.com/celebrity/1000047/","avatars":{"small":"http://img3.doubanio.com/img/celebrity/small/2086.jpg","large":"http://img3.doubanio.com/img/celebrity/large/2086.jpg","medium":"http://img3.doubanio.com/img/celebrity/medium/2086.jpg"},"name":"扎克·布拉夫","id":"1000047"},{"alt":"https://movie.douban.com/celebrity/1323890/","avatars":{"small":"http://img3.doubanio.com/img/celebrity/small/1433486813.18.jpg","large":"http://img3.doubanio.com/img/celebrity/large/1433486813.18.jpg","medium":"http://img3.doubanio.com/img/celebrity/medium/1433486813.18.jpg"},"name":"皮尔斯·加格农","id":"1323890"},{"alt":"https://movie.douban.com/celebrity/1035673/","avatars":{"small":"http://img3.doubanio.com/img/celebrity/small/49749.jpg","large":"http://img3.doubanio.com/img/celebrity/large/49749.jpg","medium":"http://img3.doubanio.com/img/celebrity/medium/49749.jpg"},"name":"凯特·哈德森","id":"1035673"}],"collect_count":2115,"original_title":"Wish I Was Here","subtype":"movie","directors":[{"alt":"https://movie.douban.com/celebrity/1000047/","avatars":{"small":"http://img3.doubanio.com/img/celebrity/small/2086.jpg","large":"http://img3.doubanio.com/img/celebrity/large/2086.jpg","medium":"http://img3.doubanio.com/img/celebrity/medium/2086.jpg"},"name":"扎克·布拉夫","id":"1000047"}],"year":"2014","images":{"small":"http://img3.douban.com/view/movie_poster_cover/ipst/public/p2185477080.jpg","large":"http://img3.douban.com/view/movie_poster_cover/lpst/public/p2185477080.jpg","medium":"http://img3.douban.com/view/movie_poster_cover/spst/public/p2185477080.jpg"},"alt":"https://movie.douban.com/subject/24381567/","id":"24381567"},{"rating":{"max":10,"average":6.9,"stars":"35","min":0},"genres":["剧情","悬疑"],"title":"判我有罪","casts":[{"alt":"https://movie.douban.com/celebrity/1312794/","avatars":{"small":"http://img3.doubanio.com/img/celebrity/small/38549.jpg","large":"http://img3.doubanio.com/img/celebrity/large/38549.jpg","medium":"http://img3.doubanio.com/img/celebrity/medium/38549.jpg"},"name":"李昕芸","id":"1312794"},{"alt":"https://movie.douban.com/celebrity/1037098/","avatars":{"small":"http://img3.douban.com/img/celebrity/small/1603.jpg","large":"http://img3.douban.com/img/celebrity/large/1603.jpg","medium":"http://img3.douban.com/img/celebrity/medium/1603.jpg"},"name":"吴镇宇","id":"1037098"},{"alt":"https://movie.douban.com/celebrity/1023718/","avatars":{"small":"http://img3.douban.com/img/celebrity/small/1403277860.52.jpg","large":"http://img3.douban.com/img/celebrity/large/1403277860.52.jpg","medium":"http://img3.douban.com/img/celebrity/medium/1403277860.52.jpg"},"name":"戴立忍","id":"1023718"}],"collect_count":295,"original_title":"判我有罪","subtype":"movie","directors":[{"alt":"https://movie.douban.com/celebrity/1351581/","avatars":{"small":"http://img3.doubanio.com/img/celebrity/small/1441617049.46.jpg","large":"http://img3.doubanio.com/img/celebrity/large/1441617049.46.jpg","medium":"http://img3.doubanio.com/img/celebrity/medium/1441617049.46.jpg"},"name":"孙亮","id":"1351581"}],"year":"2015","images":{"small":"http://img3.douban.com/view/movie_poster_cover/ipst/public/p2337060062.jpg","large":"http://img3.douban.com/view/movie_poster_cover/lpst/public/p2337060062.jpg","medium":"http://img3.douban.com/view/movie_poster_cover/spst/public/p2337060062.jpg"},"alt":"https://movie.douban.com/subject/25859593/","id":"25859593"},{"rating":{"max":10,"average":0,"stars":"00","min":0},"genres":["剧情"],"title":"布基兰","casts":[{"alt":"https://movie.douban.com/celebrity/1356250/","avatars":{"small":"http://img3.doubanio.com/f/movie/ca527386eb8c4e325611e22dfcb04cc116d6b423/pics/movie/celebrity-default-small.png","large":"http://img3.douban.com/f/movie/63acc16ca6309ef191f0378faf793d1096a3e606/pics/movie/celebrity-default-large.png","medium":"http://img3.doubanio.com/f/movie/8dd0c794499fe925ae2ae89ee30cd225750457b4/pics/movie/celebrity-default-medium.png"},"name":"王宇","id":"1356250"},{"alt":"https://movie.douban.com/celebrity/1356251/","avatars":{"small":"http://img3.doubanio.com/f/movie/ca527386eb8c4e325611e22dfcb04cc116d6b423/pics/movie/celebrity-default-small.png","large":"http://img3.douban.com/f/movie/63acc16ca6309ef191f0378faf793d1096a3e606/pics/movie/celebrity-default-large.png","medium":"http://img3.doubanio.com/f/movie/8dd0c794499fe925ae2ae89ee30cd225750457b4/pics/movie/celebrity-default-medium.png"},"name":"刘兴盛","id":"1356251"},{"alt":"https://movie.douban.com/celebrity/1356252/","avatars":{"small":"http://img3.doubanio.com/f/movie/ca527386eb8c4e325611e22dfcb04cc116d6b423/pics/movie/celebrity-default-small.png","large":"http://img3.douban.com/f/movie/63acc16ca6309ef191f0378faf793d1096a3e606/pics/movie/celebrity-default-large.png","medium":"http://img3.doubanio.com/f/movie/8dd0c794499fe925ae2ae89ee30cd225750457b4/pics/movie/celebrity-default-medium.png"},"name":"娜仁其木格","id":"1356252"}],"collect_count":37,"original_title":"布基兰","subtype":"movie","directors":[{"alt":"https://movie.douban.com/celebrity/1356249/","avatars":{"small":"http://img3.douban.com/img/celebrity/small/1459492239.0.jpg","large":"http://img3.douban.com/img/celebrity/large/1459492239.0.jpg","medium":"http://img3.douban.com/img/celebrity/medium/1459492239.0.jpg"},"name":"安兴伟","id":"1356249"}],"year":"2016","images":{"small":"http://img3.douban.com/view/movie_poster_cover/ipst/public/p2327391895.jpg","large":"http://img3.douban.com/view/movie_poster_cover/lpst/public/p2327391895.jpg","medium":"http://img3.douban.com/view/movie_poster_cover/spst/public/p2327391895.jpg"},"alt":"https://movie.douban.com/subject/25848260/","id":"25848260"},{"rating":{"max":10,"average":0,"stars":"00","min":0},"genres":["悬疑","惊悚"],"title":"妄想症","casts":[{"alt":"https://movie.douban.com/celebrity/1275779/","avatars":{"small":"http://img3.douban.com/img/celebrity/small/1426919557.0.jpg","large":"http://img3.douban.com/img/celebrity/large/1426919557.0.jpg","medium":"http://img3.douban.com/img/celebrity/medium/1426919557.0.jpg"},"name":"周柏豪 ","id":"1275779"},{"alt":"https://movie.douban.com/celebrity/1316825/","avatars":{"small":"http://img3.douban.com/img/celebrity/small/1372235275.74.jpg","large":"http://img3.douban.com/img/celebrity/large/1372235275.74.jpg","medium":"http://img3.douban.com/img/celebrity/medium/1372235275.74.jpg"},"name":"安琥","id":"1316825"},{"alt":"https://movie.douban.com/celebrity/1338838/","avatars":{"small":"http://img3.douban.com/img/celebrity/small/9vPBM4MxYe4cel_avatar_uploaded1394275282.81.jpg","large":"http://img3.douban.com/img/celebrity/large/9vPBM4MxYe4cel_avatar_uploaded1394275282.81.jpg","medium":"http://img3.douban.com/img/celebrity/medium/9vPBM4MxYe4cel_avatar_uploaded1394275282.81.jpg"},"name":"洪辰","id":"1338838"}],"collect_count":17,"original_title":"妄想症","subtype":"movie","directors":[{"alt":"https://movie.douban.com/celebrity/1293885/","avatars":{"small":"http://img3.douban.com/img/celebrity/small/17762.jpg","large":"http://img3.douban.com/img/celebrity/large/17762.jpg","medium":"http://img3.douban.com/img/celebrity/medium/17762.jpg"},"name":"彭发","id":"1293885"}],"year":"2016","images":{"small":"http://img3.doubanio.com/view/movie_poster_cover/ipst/public/p2337457648.jpg","large":"http://img3.doubanio.com/view/movie_poster_cover/lpst/public/p2337457648.jpg","medium":"http://img3.doubanio.com/view/movie_poster_cover/spst/public/p2337457648.jpg"},"alt":"https://movie.douban.com/subject/26608232/","id":"26608232"},{"rating":{"max":10,"average":0,"stars":"00","min":0},"genres":["剧情","爱情"],"title":"男神抱抱","casts":[{"alt":"https://movie.douban.com/celebrity/1340408/","avatars":{"small":"http://img3.douban.com/img/celebrity/small/1460103520.12.jpg","large":"http://img3.douban.com/img/celebrity/large/1460103520.12.jpg","medium":"http://img3.douban.com/img/celebrity/medium/1460103520.12.jpg"},"name":"天悦","id":"1340408"},{"alt":"https://movie.douban.com/celebrity/1356617/","avatars":{"small":"http://img3.douban.com/img/celebrity/small/1460104388.5.jpg","large":"http://img3.douban.com/img/celebrity/large/1460104388.5.jpg","medium":"http://img3.douban.com/img/celebrity/medium/1460104388.5.jpg"},"name":"荣梓希","id":"1356617"},{"alt":"https://movie.douban.com/celebrity/1356618/","avatars":{"small":"http://img3.doubanio.com/img/celebrity/small/1460103486.87.jpg","large":"http://img3.doubanio.com/img/celebrity/large/1460103486.87.jpg","medium":"http://img3.doubanio.com/img/celebrity/medium/1460103486.87.jpg"},"name":"杨彤","id":"1356618"}],"collect_count":18,"original_title":"男神抱抱","subtype":"movie","directors":[{"alt":"https://movie.douban.com/celebrity/1356615/","avatars":{"small":"http://img3.doubanio.com/f/movie/ca527386eb8c4e325611e22dfcb04cc116d6b423/pics/movie/celebrity-default-small.png","large":"http://img3.douban.com/f/movie/63acc16ca6309ef191f0378faf793d1096a3e606/pics/movie/celebrity-default-large.png","medium":"http://img3.doubanio.com/f/movie/8dd0c794499fe925ae2ae89ee30cd225750457b4/pics/movie/celebrity-default-medium.png"},"name":"李小军","id":"1356615"}],"year":"2016","images":{"small":"http://img3.doubanio.com/view/movie_poster_cover/ipst/public/p2333509077.jpg","large":"http://img3.doubanio.com/view/movie_poster_cover/lpst/public/p2333509077.jpg","medium":"http://img3.doubanio.com/view/movie_poster_cover/spst/public/p2333509077.jpg"},"alt":"https://movie.douban.com/subject/26767718/","id":"26767718"},{"rating":{"max":10,"average":0,"stars":"00","min":0},"genres":["剧情"],"title":"雏鸟的天空","casts":[{"alt":"https://movie.douban.com/celebrity/1316575/","avatars":{"small":"http://img3.douban.com/img/celebrity/small/36802.jpg","large":"http://img3.douban.com/img/celebrity/large/36802.jpg","medium":"http://img3.douban.com/img/celebrity/medium/36802.jpg"},"name":"李凤绪","id":"1316575"},{"alt":null,"avatars":null,"name":"杨小米","id":null},{"alt":"https://movie.douban.com/celebrity/1320873/","avatars":{"small":"http://img3.doubanio.com/img/celebrity/small/1461935231.38.jpg","large":"http://img3.doubanio.com/img/celebrity/large/1461935231.38.jpg","medium":"http://img3.doubanio.com/img/celebrity/medium/1461935231.38.jpg"},"name":"李金哲","id":"1320873"}],"collect_count":9,"original_title":"雏鸟的天空","subtype":"movie","directors":[{"alt":null,"avatars":null,"name":"占俊科","id":null}],"year":"2016","images":{"small":"http://img3.doubanio.com/view/movie_poster_cover/ipst/public/p2336631136.jpg","large":"http://img3.doubanio.com/view/movie_poster_cover/lpst/public/p2336631136.jpg","medium":"http://img3.doubanio.com/view/movie_poster_cover/spst/public/p2336631136.jpg"},"alt":"https://movie.douban.com/subject/26438799/","id":"26438799"},{"rating":{"max":10,"average":6.4,"stars":"35","min":0},"genres":["科幻","悬疑","惊悚"],"title":"幻体：续命游戏","casts":[{"alt":"https://movie.douban.com/celebrity/1053623/","avatars":{"small":"http://img3.doubanio.com/img/celebrity/small/48608.jpg","large":"http://img3.doubanio.com/img/celebrity/large/48608.jpg","medium":"http://img3.doubanio.com/img/celebrity/medium/48608.jpg"},"name":"瑞恩·雷诺兹","id":"1053623"},{"alt":"https://movie.douban.com/celebrity/1054393/","avatars":{"small":"http://img3.doubanio.com/img/celebrity/small/1374649659.58.jpg","large":"http://img3.doubanio.com/img/celebrity/large/1374649659.58.jpg","medium":"http://img3.doubanio.com/img/celebrity/medium/1374649659.58.jpg"},"name":"本·金斯利","id":"1054393"},{"alt":"https://movie.douban.com/celebrity/1000008/","avatars":{"small":"http://img3.doubanio.com/img/celebrity/small/2817.jpg","large":"http://img3.doubanio.com/img/celebrity/large/2817.jpg","medium":"http://img3.doubanio.com/img/celebrity/medium/2817.jpg"},"name":"马修·古迪","id":"1000008"}],"collect_count":8586,"original_title":"Self/less","subtype":"movie","directors":[{"alt":"https://movie.douban.com/celebrity/1018044/","avatars":{"small":"http://img3.douban.com/img/celebrity/small/57224.jpg","large":"http://img3.douban.com/img/celebrity/large/57224.jpg","medium":"http://img3.douban.com/img/celebrity/medium/57224.jpg"},"name":"塔西姆·辛","id":"1018044"}],"year":"2015","images":{"small":"http://img3.douban.com/view/movie_poster_cover/ipst/public/p2339513854.jpg","large":"http://img3.douban.com/view/movie_poster_cover/lpst/public/p2339513854.jpg","medium":"http://img3.douban.com/view/movie_poster_cover/spst/public/p2339513854.jpg"},"alt":"https://movie.douban.com/subject/24325815/","id":"24325815"},{"rating":{"max":10,"average":7.5,"stars":"40","min":0},"genres":["剧情","爱情","同性"],"title":"再见，在也不见","casts":[{"alt":"https://movie.douban.com/celebrity/1211987/","avatars":{"small":"http://img3.douban.com/img/celebrity/small/22033.jpg","large":"http://img3.douban.com/img/celebrity/large/22033.jpg","medium":"http://img3.douban.com/img/celebrity/medium/22033.jpg"},"name":"陈柏霖","id":"1211987"},{"alt":"https://movie.douban.com/celebrity/1051157/","avatars":{"small":"http://img3.douban.com/img/celebrity/small/4991.jpg","large":"http://img3.douban.com/img/celebrity/large/4991.jpg","medium":"http://img3.douban.com/img/celebrity/medium/4991.jpg"},"name":"杨祐宁","id":"1051157"},{"alt":"https://movie.douban.com/celebrity/1020487/","avatars":{"small":"http://img3.doubanio.com/img/celebrity/small/1477.jpg","large":"http://img3.doubanio.com/img/celebrity/large/1477.jpg","medium":"http://img3.doubanio.com/img/celebrity/medium/1477.jpg"},"name":"蒋雯丽","id":"1020487"}],"collect_count":175,"original_title":"再見，在也不見","subtype":"movie","directors":[{"alt":"https://movie.douban.com/celebrity/1341214/","avatars":{"small":"http://img3.doubanio.com/img/celebrity/small/Y3yyqH8ID88cel_avatar_uploaded1404318476.79.jpg","large":"http://img3.doubanio.com/img/celebrity/large/Y3yyqH8ID88cel_avatar_uploaded1404318476.79.jpg","medium":"http://img3.doubanio.com/img/celebrity/medium/Y3yyqH8ID88cel_avatar_uploaded1404318476.79.jpg"},"name":"忻钰坤","id":"1341214"},{"alt":"https://movie.douban.com/celebrity/1332552/","avatars":{"small":"http://img3.doubanio.com/f/movie/ca527386eb8c4e325611e22dfcb04cc116d6b423/pics/movie/celebrity-default-small.png","large":"http://img3.douban.com/f/movie/63acc16ca6309ef191f0378faf793d1096a3e606/pics/movie/celebrity-default-large.png","medium":"http://img3.doubanio.com/f/movie/8dd0c794499fe925ae2ae89ee30cd225750457b4/pics/movie/celebrity-default-medium.png"},"name":"陈世杰","id":"1332552"},{"alt":"https://movie.douban.com/celebrity/1314350/","avatars":{"small":"http://img3.doubanio.com/f/movie/ca527386eb8c4e325611e22dfcb04cc116d6b423/pics/movie/celebrity-default-small.png","large":"http://img3.douban.com/f/movie/63acc16ca6309ef191f0378faf793d1096a3e606/pics/movie/celebrity-default-large.png","medium":"http://img3.doubanio.com/f/movie/8dd0c794499fe925ae2ae89ee30cd225750457b4/pics/movie/celebrity-default-medium.png"},"name":"西瓦罗·孔萨库","id":"1314350"}],"year":"2015","images":{"small":"http://img3.douban.com/view/movie_poster_cover/ipst/public/p2267584071.jpg","large":"http://img3.douban.com/view/movie_poster_cover/lpst/public/p2267584071.jpg","medium":"http://img3.douban.com/view/movie_poster_cover/spst/public/p2267584071.jpg"},"alt":"https://movie.douban.com/subject/26282530/","id":"26282530"},{"rating":{"max":10,"average":8.5,"stars":"45","min":0},"genres":["剧情","动作","犯罪"],"title":"超脑48小时","casts":[{"alt":"https://movie.douban.com/celebrity/1016671/","avatars":{"small":"http://img3.douban.com/img/celebrity/small/34511.jpg","large":"http://img3.douban.com/img/celebrity/large/34511.jpg","medium":"http://img3.douban.com/img/celebrity/medium/34511.jpg"},"name":"凯文·科斯特纳","id":"1016671"},{"alt":"https://movie.douban.com/celebrity/1010507/","avatars":{"small":"http://img3.douban.com/img/celebrity/small/104.jpg","large":"http://img3.douban.com/img/celebrity/large/104.jpg","medium":"http://img3.douban.com/img/celebrity/medium/104.jpg"},"name":"加里·奥德曼","id":"1010507"},{"alt":"https://movie.douban.com/celebrity/1047994/","avatars":{"small":"http://img3.doubanio.com/img/celebrity/small/259.jpg","large":"http://img3.doubanio.com/img/celebrity/large/259.jpg","medium":"http://img3.doubanio.com/img/celebrity/medium/259.jpg"},"name":"汤米·李·琼斯","id":"1047994"}],"collect_count":325,"original_title":"Criminal","subtype":"movie","directors":[{"alt":"https://movie.douban.com/celebrity/1005450/","avatars":{"small":"http://img3.douban.com/img/celebrity/small/1414909801.53.jpg","large":"http://img3.douban.com/img/celebrity/large/1414909801.53.jpg","medium":"http://img3.douban.com/img/celebrity/medium/1414909801.53.jpg"},"name":"阿里尔·弗罗门","id":"1005450"}],"year":"2016","images":{"small":"http://img3.douban.com/view/movie_poster_cover/ipst/public/p2332376060.jpg","large":"http://img3.douban.com/view/movie_poster_cover/lpst/public/p2332376060.jpg","medium":"http://img3.douban.com/view/movie_poster_cover/spst/public/p2332376060.jpg"},"alt":"https://movie.douban.com/subject/25944714/","id":"25944714"},{"rating":{"max":10,"average":0,"stars":"00","min":0},"genres":["悬疑","惊悚"],"title":"别开门","casts":[{"alt":"https://movie.douban.com/celebrity/1321437/","avatars":{"small":"http://img3.douban.com/img/celebrity/small/1452160614.91.jpg","large":"http://img3.douban.com/img/celebrity/large/1452160614.91.jpg","medium":"http://img3.douban.com/img/celebrity/medium/1452160614.91.jpg"},"name":"徐立","id":"1321437"},{"alt":"https://movie.douban.com/celebrity/1351310/","avatars":{"small":"http://img3.douban.com/img/celebrity/small/1461563557.93.jpg","large":"http://img3.douban.com/img/celebrity/large/1461563557.93.jpg","medium":"http://img3.douban.com/img/celebrity/medium/1461563557.93.jpg"},"name":"曲少石","id":"1351310"},{"alt":"https://movie.douban.com/celebrity/1335210/","avatars":{"small":"http://img3.douban.com/img/celebrity/small/1423048712.81.jpg","large":"http://img3.douban.com/img/celebrity/large/1423048712.81.jpg","medium":"http://img3.douban.com/img/celebrity/medium/1423048712.81.jpg"},"name":"杨珑","id":"1335210"}],"collect_count":93,"original_title":"别开门","subtype":"movie","directors":[{"alt":"https://movie.douban.com/celebrity/1357085/","avatars":{"small":"http://img3.doubanio.com/f/movie/ca527386eb8c4e325611e22dfcb04cc116d6b423/pics/movie/celebrity-default-small.png","large":"http://img3.douban.com/f/movie/63acc16ca6309ef191f0378faf793d1096a3e606/pics/movie/celebrity-default-large.png","medium":"http://img3.doubanio.com/f/movie/8dd0c794499fe925ae2ae89ee30cd225750457b4/pics/movie/celebrity-default-medium.png"},"name":"周阁","id":"1357085"}],"year":"2015","images":{"small":"http://img3.douban.com/view/movie_poster_cover/ipst/public/p2326228232.jpg","large":"http://img3.douban.com/view/movie_poster_cover/lpst/public/p2326228232.jpg","medium":"http://img3.douban.com/view/movie_poster_cover/spst/public/p2326228232.jpg"},"alt":"https://movie.douban.com/subject/26693297/","id":"26693297"},{"rating":{"max":10,"average":0,"stars":"00","min":0},"genres":["悬疑","惊悚"],"title":"笔仙诡影","casts":[{"alt":"https://movie.douban.com/celebrity/1351879/","avatars":{"small":"http://img3.doubanio.com/f/movie/ca527386eb8c4e325611e22dfcb04cc116d6b423/pics/movie/celebrity-default-small.png","large":"http://img3.douban.com/f/movie/63acc16ca6309ef191f0378faf793d1096a3e606/pics/movie/celebrity-default-large.png","medium":"http://img3.doubanio.com/f/movie/8dd0c794499fe925ae2ae89ee30cd225750457b4/pics/movie/celebrity-default-medium.png"},"name":"宋懿洁","id":"1351879"},{"alt":"https://movie.douban.com/celebrity/1351877/","avatars":{"small":"http://img3.doubanio.com/f/movie/ca527386eb8c4e325611e22dfcb04cc116d6b423/pics/movie/celebrity-default-small.png","large":"http://img3.douban.com/f/movie/63acc16ca6309ef191f0378faf793d1096a3e606/pics/movie/celebrity-default-large.png","medium":"http://img3.doubanio.com/f/movie/8dd0c794499fe925ae2ae89ee30cd225750457b4/pics/movie/celebrity-default-medium.png"},"name":"蒋欣奇","id":"1351877"},{"alt":"https://movie.douban.com/celebrity/1350389/","avatars":{"small":"http://img3.douban.com/img/celebrity/small/1460897440.15.jpg","large":"http://img3.douban.com/img/celebrity/large/1460897440.15.jpg","medium":"http://img3.douban.com/img/celebrity/medium/1460897440.15.jpg"},"name":"张蓝艺","id":"1350389"}],"collect_count":92,"original_title":"笔仙诡影","subtype":"movie","directors":[{"alt":"https://movie.douban.com/celebrity/1351882/","avatars":{"small":"http://img3.doubanio.com/f/movie/ca527386eb8c4e325611e22dfcb04cc116d6b423/pics/movie/celebrity-default-small.png","large":"http://img3.douban.com/f/movie/63acc16ca6309ef191f0378faf793d1096a3e606/pics/movie/celebrity-default-large.png","medium":"http://img3.doubanio.com/f/movie/8dd0c794499fe925ae2ae89ee30cd225750457b4/pics/movie/celebrity-default-medium.png"},"name":"高育新","id":"1351882"},{"alt":"https://movie.douban.com/celebrity/1351881/","avatars":{"small":"http://img3.doubanio.com/f/movie/ca527386eb8c4e325611e22dfcb04cc116d6b423/pics/movie/celebrity-default-small.png","large":"http://img3.douban.com/f/movie/63acc16ca6309ef191f0378faf793d1096a3e606/pics/movie/celebrity-default-large.png","medium":"http://img3.doubanio.com/f/movie/8dd0c794499fe925ae2ae89ee30cd225750457b4/pics/movie/celebrity-default-medium.png"},"name":"刘峰","id":"1351881"}],"year":"2016","images":{"small":"http://img3.doubanio.com/view/movie_poster_cover/ipst/public/p2341856158.jpg","large":"http://img3.doubanio.com/view/movie_poster_cover/lpst/public/p2341856158.jpg","medium":"http://img3.doubanio.com/view/movie_poster_cover/spst/public/p2341856158.jpg"},"alt":"https://movie.douban.com/subject/26614128/","id":"26614128"},{"rating":{"max":10,"average":2.9,"stars":"15","min":0},"genres":["喜剧","悬疑"],"title":"谎言大爆炸","casts":[{"alt":"https://movie.douban.com/celebrity/1313285/","avatars":{"small":"http://img3.doubanio.com/img/celebrity/small/1441793528.59.jpg","large":"http://img3.doubanio.com/img/celebrity/large/1441793528.59.jpg","medium":"http://img3.doubanio.com/img/celebrity/medium/1441793528.59.jpg"},"name":"孙坚","id":"1313285"},{"alt":"https://movie.douban.com/celebrity/1275547/","avatars":{"small":"http://img3.doubanio.com/img/celebrity/small/11386.jpg","large":"http://img3.doubanio.com/img/celebrity/large/11386.jpg","medium":"http://img3.doubanio.com/img/celebrity/medium/11386.jpg"},"name":"白冰","id":"1275547"},{"alt":"https://movie.douban.com/celebrity/1275490/","avatars":{"small":"http://img3.doubanio.com/img/celebrity/small/48498.jpg","large":"http://img3.doubanio.com/img/celebrity/large/48498.jpg","medium":"http://img3.doubanio.com/img/celebrity/medium/48498.jpg"},"name":"潘霜霜","id":"1275490"}],"collect_count":182,"original_title":"谎言大爆炸","subtype":"movie","directors":[{"alt":"https://movie.douban.com/celebrity/1314175/","avatars":{"small":"http://img3.douban.com/img/celebrity/small/22192.jpg","large":"http://img3.douban.com/img/celebrity/large/22192.jpg","medium":"http://img3.douban.com/img/celebrity/medium/22192.jpg"},"name":"侯亮","id":"1314175"}],"year":"2016","images":{"small":"http://img3.douban.com/view/movie_poster_cover/ipst/public/p2335656403.jpg","large":"http://img3.douban.com/view/movie_poster_cover/lpst/public/p2335656403.jpg","medium":"http://img3.douban.com/view/movie_poster_cover/spst/public/p2335656403.jpg"},"alt":"https://movie.douban.com/subject/26686170/","id":"26686170"},{"rating":{"max":10,"average":0,"stars":"00","min":0},"genres":["喜剧","爱情"],"title":"购物女王","casts":[{"alt":"https://movie.douban.com/celebrity/1274437/","avatars":{"small":"http://img3.douban.com/img/celebrity/small/48635.jpg","large":"http://img3.douban.com/img/celebrity/large/48635.jpg","medium":"http://img3.douban.com/img/celebrity/medium/48635.jpg"},"name":"秦海璐","id":"1274437"},{"alt":"https://movie.douban.com/celebrity/1274683/","avatars":{"small":"http://img3.douban.com/img/celebrity/small/5945.jpg","large":"http://img3.douban.com/img/celebrity/large/5945.jpg","medium":"http://img3.douban.com/img/celebrity/medium/5945.jpg"},"name":"范逸臣","id":"1274683"},{"alt":"https://movie.douban.com/celebrity/1354235/","avatars":{"small":"http://img3.doubanio.com/img/celebrity/small/DTieGElyNREcel_avatar_uploaded1453609509.77.jpg","large":"http://img3.doubanio.com/img/celebrity/large/DTieGElyNREcel_avatar_uploaded1453609509.77.jpg","medium":"http://img3.doubanio.com/img/celebrity/medium/DTieGElyNREcel_avatar_uploaded1453609509.77.jpg"},"name":"区宁","id":"1354235"}],"collect_count":5,"original_title":"购物女王","subtype":"movie","directors":[{"alt":"https://movie.douban.com/celebrity/1356909/","avatars":{"small":"http://img3.doubanio.com/f/movie/ca527386eb8c4e325611e22dfcb04cc116d6b423/pics/movie/celebrity-default-small.png","large":"http://img3.douban.com/f/movie/63acc16ca6309ef191f0378faf793d1096a3e606/pics/movie/celebrity-default-large.png","medium":"http://img3.doubanio.com/f/movie/8dd0c794499fe925ae2ae89ee30cd225750457b4/pics/movie/celebrity-default-medium.png"},"name":"柳广辉","id":"1356909"}],"year":"2012","images":{"small":"http://img3.douban.com/view/movie_poster_cover/ipst/public/p2335971952.jpg","large":"http://img3.douban.com/view/movie_poster_cover/lpst/public/p2335971952.jpg","medium":"http://img3.douban.com/view/movie_poster_cover/spst/public/p2335971952.jpg"},"alt":"https://movie.douban.com/subject/26772866/","id":"26772866"},{"rating":{"max":10,"average":0,"stars":"00","min":0},"genres":["喜剧","动作","动画"],"title":"愤怒的小鸟","casts":[{"alt":"https://movie.douban.com/celebrity/1049521/","avatars":{"small":"http://img3.doubanio.com/img/celebrity/small/33797.jpg","large":"http://img3.doubanio.com/img/celebrity/large/33797.jpg","medium":"http://img3.doubanio.com/img/celebrity/medium/33797.jpg"},"name":"杰森·苏戴奇斯","id":"1049521"},{"alt":"https://movie.douban.com/celebrity/1305235/","avatars":{"small":"http://img3.douban.com/img/celebrity/small/38561.jpg","large":"http://img3.douban.com/img/celebrity/large/38561.jpg","medium":"http://img3.douban.com/img/celebrity/medium/38561.jpg"},"name":"乔什·加德","id":"1305235"},{"alt":"https://movie.douban.com/celebrity/1013797/","avatars":{"small":"http://img3.douban.com/img/celebrity/small/28522.jpg","large":"http://img3.douban.com/img/celebrity/large/28522.jpg","medium":"http://img3.douban.com/img/celebrity/medium/28522.jpg"},"name":"丹尼·麦克布耐德","id":"1013797"}],"collect_count":58,"original_title":"The Angry Birds Movie","subtype":"movie","directors":[{"alt":"https://movie.douban.com/celebrity/1288264/","avatars":{"small":"http://img3.douban.com/img/celebrity/small/1437105433.0.jpg","large":"http://img3.douban.com/img/celebrity/large/1437105433.0.jpg","medium":"http://img3.douban.com/img/celebrity/medium/1437105433.0.jpg"},"name":"克莱·凯蒂","id":"1288264"},{"alt":null,"avatars":null,"name":"Fergal Reilly","id":null}],"year":"2016","images":{"small":"http://img3.douban.com/view/movie_poster_cover/ipst/public/p2333887481.jpg","large":"http://img3.douban.com/view/movie_poster_cover/lpst/public/p2333887481.jpg","medium":"http://img3.douban.com/view/movie_poster_cover/spst/public/p2333887481.jpg"},"alt":"https://movie.douban.com/subject/6873736/","id":"6873736"},{"rating":{"max":10,"average":5.9,"stars":"30","min":0},"genres":["动作","爱情","科幻"],"title":"分歧者3：忠诚世界","casts":[{"alt":"https://movie.douban.com/celebrity/1040526/","avatars":{"small":"http://img3.doubanio.com/img/celebrity/small/42217.jpg","large":"http://img3.doubanio.com/img/celebrity/large/42217.jpg","medium":"http://img3.doubanio.com/img/celebrity/medium/42217.jpg"},"name":"谢琳·伍德蕾","id":"1040526"},{"alt":"https://movie.douban.com/celebrity/1314251/","avatars":{"small":"http://img3.douban.com/img/celebrity/small/44220.jpg","large":"http://img3.douban.com/img/celebrity/large/44220.jpg","medium":"http://img3.douban.com/img/celebrity/medium/44220.jpg"},"name":"提奥·詹姆斯","id":"1314251"},{"alt":"https://movie.douban.com/celebrity/1006974/","avatars":{"small":"http://img3.doubanio.com/img/celebrity/small/52938.jpg","large":"http://img3.doubanio.com/img/celebrity/large/52938.jpg","medium":"http://img3.doubanio.com/img/celebrity/medium/52938.jpg"},"name":"杰夫·丹尼尔斯","id":"1006974"}],"collect_count":494,"original_title":"The Divergent Series: Allegiant","subtype":"movie","directors":[{"alt":"https://movie.douban.com/celebrity/1297058/","avatars":{"small":"http://img3.douban.com/img/celebrity/small/32301.jpg","large":"http://img3.douban.com/img/celebrity/large/32301.jpg","medium":"http://img3.douban.com/img/celebrity/medium/32301.jpg"},"name":"罗伯特·斯文克 ","id":"1297058"}],"year":"2016","images":{"small":"http://img3.douban.com/view/movie_poster_cover/ipst/public/p2333870311.jpg","large":"http://img3.douban.com/view/movie_poster_cover/lpst/public/p2333870311.jpg","medium":"http://img3.douban.com/view/movie_poster_cover/spst/public/p2333870311.jpg"},"alt":"https://movie.douban.com/subject/25794302/","id":"25794302"},{"rating":{"max":10,"average":0,"stars":"00","min":0},"genres":["剧情","爱情"],"title":"夜孔雀","casts":[{"alt":"https://movie.douban.com/celebrity/1049732/","avatars":{"small":"http://img3.douban.com/img/celebrity/small/38640.jpg","large":"http://img3.douban.com/img/celebrity/large/38640.jpg","medium":"http://img3.douban.com/img/celebrity/medium/38640.jpg"},"name":"刘亦菲","id":"1049732"},{"alt":"https://movie.douban.com/celebrity/1000572/","avatars":{"small":"http://img3.douban.com/img/celebrity/small/43.jpg","large":"http://img3.douban.com/img/celebrity/large/43.jpg","medium":"http://img3.douban.com/img/celebrity/medium/43.jpg"},"name":"刘烨","id":"1000572"},{"alt":"https://movie.douban.com/celebrity/1275100/","avatars":{"small":"http://img3.doubanio.com/img/celebrity/small/22866.jpg","large":"http://img3.doubanio.com/img/celebrity/large/22866.jpg","medium":"http://img3.doubanio.com/img/celebrity/medium/22866.jpg"},"name":"余少群","id":"1275100"}],"collect_count":139,"original_title":"夜孔雀","subtype":"movie","directors":[{"alt":"https://movie.douban.com/celebrity/1033214/","avatars":{"small":"http://img3.douban.com/img/celebrity/small/13574.jpg","large":"http://img3.douban.com/img/celebrity/large/13574.jpg","medium":"http://img3.douban.com/img/celebrity/medium/13574.jpg"},"name":"戴思杰","id":"1033214"}],"year":"2015","images":{"small":"http://img3.douban.com/view/movie_poster_cover/ipst/public/p2332347501.jpg","large":"http://img3.douban.com/view/movie_poster_cover/lpst/public/p2332347501.jpg","medium":"http://img3.douban.com/view/movie_poster_cover/spst/public/p2332347501.jpg"},"alt":"https://movie.douban.com/subject/24743728/","id":"24743728"},{"rating":{"max":10,"average":0,"stars":"00","min":0},"genres":["剧情","动作"],"title":"钢刀","casts":[{"alt":"https://movie.douban.com/celebrity/1050590/","avatars":{"small":"http://img3.douban.com/img/celebrity/small/3030.jpg","large":"http://img3.douban.com/img/celebrity/large/3030.jpg","medium":"http://img3.douban.com/img/celebrity/medium/3030.jpg"},"name":"何润东","id":"1050590"},{"alt":"https://movie.douban.com/celebrity/1317113/","avatars":{"small":"http://img3.douban.com/img/celebrity/small/46584.jpg","large":"http://img3.douban.com/img/celebrity/large/46584.jpg","medium":"http://img3.douban.com/img/celebrity/medium/46584.jpg"},"name":"李东学","id":"1317113"},{"alt":"https://movie.douban.com/celebrity/1275936/","avatars":{"small":"http://img3.doubanio.com/img/celebrity/small/1360637759.9.jpg","large":"http://img3.doubanio.com/img/celebrity/large/1360637759.9.jpg","medium":"http://img3.doubanio.com/img/celebrity/medium/1360637759.9.jpg"},"name":"夏梓桐","id":"1275936"}],"collect_count":58,"original_title":"钢刀","subtype":"movie","directors":[{"alt":"https://movie.douban.com/celebrity/1275626/","avatars":{"small":"http://img3.doubanio.com/img/celebrity/small/1458020032.08.jpg","large":"http://img3.doubanio.com/img/celebrity/large/1458020032.08.jpg","medium":"http://img3.doubanio.com/img/celebrity/medium/1458020032.08.jpg"},"name":"阿甘","id":"1275626"}],"year":"2016","images":{"small":"http://img3.doubanio.com/view/movie_poster_cover/ipst/public/p2325714098.jpg","large":"http://img3.doubanio.com/view/movie_poster_cover/lpst/public/p2325714098.jpg","medium":"http://img3.doubanio.com/view/movie_poster_cover/spst/public/p2325714098.jpg"},"alt":"https://movie.douban.com/subject/21264283/","id":"21264283"}]
     * title : 即将上映的电影
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
     * rating : {"max":10,"average":0,"stars":"00","min":0}
     * genres : ["剧情","儿童","爱情"]
     * title : 风铃上的卡片
     * casts : [{"alt":null,"avatars":null,"name":"李春丽","id":null},{"alt":null,"avatars":null,"name":"付诗雨","id":null},{"alt":null,"avatars":null,"name":"高仁会","id":null}]
     * collect_count : 8
     * original_title : 风铃上的卡片
     * subtype : movie
     * directors : [{"alt":"https://movie.douban.com/celebrity/1335111/","avatars":{"small":"http://img3.douban.com/img/celebrity/small/1383666301.95.jpg","large":"http://img3.douban.com/img/celebrity/large/1383666301.95.jpg","medium":"http://img3.douban.com/img/celebrity/medium/1383666301.95.jpg"},"name":"胡阳","id":"1335111"}]
     * year : 2015
     * images : {"small":"http://img3.douban.com/view/movie_poster_cover/ipst/public/p2328692972.jpg","large":"http://img3.douban.com/view/movie_poster_cover/lpst/public/p2328692972.jpg","medium":"http://img3.douban.com/view/movie_poster_cover/spst/public/p2328692972.jpg"}
     * alt : https://movie.douban.com/subject/26765192/
     * id : 26765192
     */

    @SerializedName("subjects")
    private List<Movie> mSubjects;

    public int getCount() {
        return mCount;
    }

    public void setCount(int count) {
        mCount = count;
    }

    public int getStart() {
        return mStart;
    }

    public void setStart(int start) {
        mStart = start;
    }

    public int getTotal() {
        return mTotal;
    }

    public void setTotal(int total) {
        mTotal = total;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        mTitle = title;
    }

    public List<Movie> getSubjects() {
        return mSubjects;
    }

    public void setSubjects(List<Movie> subjects) {
        mSubjects = subjects;
    }

    public static class Movie {
        /**
         * max : 10
         * average : 0
         * stars : 00
         * min : 0
         */

        @SerializedName("rating")
        private Rating mRating;
        @SerializedName("title")
        private String mTitle;
        @SerializedName("collect_count")
        private int mCollectCount;
        @SerializedName("original_title")
        private String mOriginalTitle;
        @SerializedName("subtype")
        private String mSubtype;
        @SerializedName("year")
        private String mYear;
        /**
         * small : http://img3.douban.com/view/movie_poster_cover/ipst/public/p2328692972.jpg
         * large : http://img3.douban.com/view/movie_poster_cover/lpst/public/p2328692972.jpg
         * medium : http://img3.douban.com/view/movie_poster_cover/spst/public/p2328692972.jpg
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
         * alt : null
         * avatars : null
         * name : 李春丽
         * id : null
         */

        @SerializedName("casts")
        private List<Cast> mCasts;
        /**
         * alt : https://movie.douban.com/celebrity/1335111/
         * avatars : {"small":"http://img3.douban.com/img/celebrity/small/1383666301.95.jpg","large":"http://img3.douban.com/img/celebrity/large/1383666301.95.jpg","medium":"http://img3.douban.com/img/celebrity/medium/1383666301.95.jpg"}
         * name : 胡阳
         * id : 1335111
         */

        @SerializedName("directors")
        private List<Director> mDirectors;

        public Rating getRating() {
            return mRating;
        }

        public void setRating(Rating rating) {
            mRating = rating;
        }

        public String getTitle() {
            return mTitle;
        }

        public void setTitle(String title) {
            mTitle = title;
        }

        public int getCollectCount() {
            return mCollectCount;
        }

        public void setCollectCount(int collectCount) {
            mCollectCount = collectCount;
        }

        public String getOriginalTitle() {
            return mOriginalTitle;
        }

        public void setOriginalTitle(String originalTitle) {
            mOriginalTitle = originalTitle;
        }

        public String getSubtype() {
            return mSubtype;
        }

        public void setSubtype(String subtype) {
            mSubtype = subtype;
        }

        public String getYear() {
            return mYear;
        }

        public void setYear(String year) {
            mYear = year;
        }

        public Images getImages() {
            return mImages;
        }

        public void setImages(Images images) {
            mImages = images;
        }

        public String getAlt() {
            return mAlt;
        }

        public void setAlt(String alt) {
            mAlt = alt;
        }

        public String getId() {
            return mId;
        }

        public void setId(String id) {
            mId = id;
        }

        public List<String> getGenres() {
            return mGenres;
        }

        public void setGenres(List<String> genres) {
            mGenres = genres;
        }

        public List<Cast> getCasts() {
            return mCasts;
        }

        public void setCasts(List<Cast> casts) {
            mCasts = casts;
        }

        public List<Director> getDirectors() {
            return mDirectors;
        }

        public void setDirectors(List<Director> directors) {
            mDirectors = directors;
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

            public int getMax() {
                return mMax;
            }

            public void setMax(int max) {
                mMax = max;
            }

            public double getAverage() {
                return mAverage;
            }

            public void setAverage(int average) {
                mAverage = average;
            }

            public String getStars() {
                return mStars;
            }

            public void setStars(String stars) {
                mStars = stars;
            }

            public int getMin() {
                return mMin;
            }

            public void setMin(int min) {
                mMin = min;
            }
        }

        public static class Images {
            @SerializedName("small")
            private String mSmall;
            @SerializedName("large")
            private String mLarge;
            @SerializedName("medium")
            private String mMedium;

            public String getSmall() {
                return mSmall;
            }

            public void setSmall(String small) {
                mSmall = small;
            }

            public String getLarge() {
                return mLarge;
            }

            public void setLarge(String large) {
                mLarge = large;
            }

            public String getMedium() {
                return mMedium;
            }

            public void setMedium(String medium) {
                mMedium = medium;
            }
        }

        public static class Cast {
            @SerializedName("alt")
            private Object mAlt;
            @SerializedName("avatars")
            private Object mAvatars;
            @SerializedName("name")
            private String mName;
            @SerializedName("id")
            private Object mId;

            public Object getAlt() {
                return mAlt;
            }

            public void setAlt(Object alt) {
                mAlt = alt;
            }

            public Object getAvatars() {
                return mAvatars;
            }

            public void setAvatars(Object avatars) {
                mAvatars = avatars;
            }

            public String getName() {
                return mName;
            }

            public void setName(String name) {
                mName = name;
            }

            public Object getId() {
                return mId;
            }

            public void setId(Object id) {
                mId = id;
            }
        }

        public static class Director {
            @SerializedName("alt")
            private String mAlt;
            /**
             * small : http://img3.douban.com/img/celebrity/small/1383666301.95.jpg
             * large : http://img3.douban.com/img/celebrity/large/1383666301.95.jpg
             * medium : http://img3.douban.com/img/celebrity/medium/1383666301.95.jpg
             */

            @SerializedName("avatars")
            private Avatars mAvatars;
            @SerializedName("name")
            private String mName;
            @SerializedName("id")
            private String mId;

            public String getAlt() {
                return mAlt;
            }

            public void setAlt(String alt) {
                mAlt = alt;
            }

            public Avatars getAvatars() {
                return mAvatars;
            }

            public void setAvatars(Avatars avatars) {
                mAvatars = avatars;
            }

            public String getName() {
                return mName;
            }

            public void setName(String name) {
                mName = name;
            }

            public String getId() {
                return mId;
            }

            public void setId(String id) {
                mId = id;
            }

            public static class Avatars {
                @SerializedName("small")
                private String mSmall;
                @SerializedName("large")
                private String mLarge;
                @SerializedName("medium")
                private String mMedium;

                public String getSmall() {
                    return mSmall;
                }

                public void setSmall(String small) {
                    mSmall = small;
                }

                public String getLarge() {
                    return mLarge;
                }

                public void setLarge(String large) {
                    mLarge = large;
                }

                public String getMedium() {
                    return mMedium;
                }

                public void setMedium(String medium) {
                    mMedium = medium;
                }
            }
        }
    }
}
