package com.hfxt.test;

public class Test1 {
    public static void main(String[] args) {

        /*//获取当前事件（毫秒级）
        long now = System.currentTimeMillis();

        //设置过期时间
        long exp = now + 1000 * 60;

        JwtBuilder builder = Jwts.builder()
                .setId("999")   //id
                .setSubject("小明")   //主体数据
                .setIssuedAt(new Date(now))     //签发时间
                .setExpiration(new Date(exp))  //过期时间
                .signWith(SignatureAlgorithm.HS256, "abcd")
                .claim("role", "admin");

        System.out.println(builder.compact());
        String token=builder.compact();

        Claims claims= Jwts.parser().setSigningKey("abcd").parseClaimsJws(token).getBody();

        System.out.println("id============》"+claims.getId());
        System.out.println("Subject============》"+claims.getSubject());

        String[] a={"10","10.5"};*/
        Test test=new Test();


    }
}
