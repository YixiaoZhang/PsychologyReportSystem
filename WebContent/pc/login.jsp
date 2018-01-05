<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
    <title>Login-心理月报系统</title>
    <script>
        if (window != window.top) top.location.href = self.location.href;
    </script>
    <link href="../assets/layui/css/layui.css" rel="stylesheet" />
    <link href="../assets/font-awesome/css/font-awesome.css" rel="stylesheet" />
    <link href="../assets/css/login.css" rel="stylesheet" />
    <link href="../assets/sideshow/css/normalize.css" rel="stylesheet" />
    <link href="../assets/sideshow/css/demo.css" rel="stylesheet" />
    <link href="../assets/sideshow/css/component.css" rel="stylesheet" />
    <!--[if IE]>
        <script src="./assets/sideshow/js/html5.js"></script>
    <![endif]-->
    <style>
        canvas {
            position: absolute;
            z-index: -1;
        }
        
        .kit-login-box header h1 {
            line-height: normal;
        }
        
        .kit-login-box header {
            height: auto;
        }
        
        .content {
            position: relative;
        }
        
        .codrops-demos {
            position: absolute;
            bottom: 0;
            left: 40%;
            z-index: 10;
        }
        
        .codrops-demos a {
            border: 2px solid rgba(242, 242, 242, 0.41);
            color: rgba(255, 255, 255, 0.51);
        }
        
        .kit-pull-right button,
        .kit-login-main .layui-form-item input {
            background-color: transparent;
            color: white;
        }
        
        .kit-login-main .layui-form-item input::-webkit-input-placeholder {
            color: white;
        }
        
        .kit-login-main .layui-form-item input:-moz-placeholder {
            color: white;
        }
        
        .kit-login-main .layui-form-item input::-moz-placeholder {
            color: white;
        }
        
        .kit-login-main .layui-form-item input:-ms-input-placeholder {
            color: white;
        }
        
        .kit-pull-right button:hover {
            border-color: #009688;
            color: #009688
        }
    </style>
</head>


<body class="kit-login-bg">
    <div class="container demo-1">
        <div class="content">
            <div id="large-header" class="large-header">
                <canvas id="demo-canvas"></canvas>
                <div class="kit-login-box">
                    <header>
                        <h1>心理月报系统</h1>
                    </header>
                    <div class="kit-login-main">
                        <form action="CheckLogin" class="layui-form" method="post">
                            <div class="layui-form-item">
                                <label class="kit-login-icon">
                                    <i class="layui-icon">&#xe612;</i>
                                </label>
                                <input type="text" name="name" lay-verify="required" autocomplete="off" placeholder="用户名" class="layui-input">
                            </div>
                            <div class="layui-form-item">
                                <label class="kit-login-icon">
                                    <i class="layui-icon">&#xe642;</i>
                                </label>
                                <input type="password" name="password" lay-verify="required" autocomplete="off" placeholder="密码" class="layui-input">
                            </div>
                           
                            <div class="layui-form-item">
                                <s:if test="#error=='true'">用户名或密码错误！<br><br></s:if>
                                <div class="kit-pull-right">
                                    <button class="layui-btn layui-btn-primary">
                                        <i class="fa fa-sign-in" aria-hidden="true"></i> 登录
                                    </button>
                                </div>
                                <div class="kit-clear"></div>
                            </div>
                        </form>
                    </div>
                    <footer>
                        <p>© JavaEE大型实验</a></p>
                    </footer>
                </div>
            </div>
        </div>
    </div>
    <!-- /container -->

    <script src="../assets/layui/layui.js"></script>
    <script src="../assets/sideshow/js/TweenLite.min.js"></script>
    <script src="../assets/sideshow/js/EasePack.min.js"></script>
    <script src="../assets/sideshow/js/rAF.js"></script>
    <script src="../assets/sideshow/js/demo-1.js"></script>
    <script>
        layui.use(['layer', 'form'], function() {
            var layer = layui.layer,
                $ = layui.jquery,
                form = layui.form;

            $('#changeCode').on('click', function() {
                $('#changeCode > img')[0].src = './build/images/GetVerfiyCode.png';
            });

            //清理左侧菜单缓存
            var index = layer.load(2, {
                shade: [0.3, '#333']
            });
            $(window).on('load', function() {
                layer.close(index);
                form.on('submit(login)', function(data) {
                    var loadIndex = layer.load(2, {
                        shade: [0.3, '#333']
                    });
                    location.href = '/';
                    // $.post(data.form.action, data.field, function(res) {
                    //     if (!res.rel) {
                    //         layer.msg(res.msg, {
                    //             icon: 2
                    //         });
                    //         loadIndex && layer.close(loadIndex);
                    //         $('#changeCode').click(); //刷新验证码
                    //     } else {
                    //         setTimeout(function() {
                    //             location.href = '/'
                    //         }, 1500);
                    //     }
                    // }, 'json');
                    return false;
                });
            }());

        });
    </script>
</body>
</html>