<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"> 
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>23种Bootstrap导航菜单布局设计jQuery插件|nav-sticky_jQuery之家-自由分享jQuery、html5、css3的插件库</title>
	<link href="../css/navcss/bootstrap.min.css" rel="stylesheet">
	<link href="../fonts/FontAwesome/font-awesome.css" rel="stylesheet">
	<link href='https://fonts.googleapis.com/css?family=Open+Sans:400,700' rel='stylesheet' type='text/css'>
	<link href="../css/navcss/animate.css" rel="stylesheet">
	<link href="../css/navcss/bootsnav.css" rel="stylesheet">
	<link rel="stylesheet" type="text/css" href="../css/navcss/htmleaf-demo.css">
	<link href="../css/navcss/overwrite.css" rel="stylesheet">
      <link href="../css/navcss/style.css" rel="stylesheet">
    	<link href="../skins/color.css" rel="stylesheet">
	<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
	<!--[if lt IE 9]>
	  <script src="js/html5shiv.min.js"></script>
	  <script src="js/respond.min.js"></script>
	<![endif]-->
<title>Insert title here</title>
</head>


<body id="home">
    <!-- Start Home -->
    <div class="pageheader">
        <div class="container">
            <h2 class="title">顶部黏贴的导航菜单</h2>
            <p>Navigation menu with sticky style</p>
        </div>
    </div>
    <!-- End Home -->
    <!-- Start Navigation -->
    <nav class="navbar navbar-default navbar-sticky bootsnav">

        <!-- Start Top Search -->
        <div class="top-search">
            <div class="container">
                <div class="input-group">
                    <span class="input-group-addon"><i class="fa fa-search"><img alt="" src="../images/search2.png"></i></span>
                    <input type="text" class="form-control" placeholder="Search">
                    <span class="input-group-addon close-search"><i class="fa fa-times"><img alt="" src="../images/close.png"></i></span>
                </div>
            </div>
        </div>
        <!-- End Top Search -->

        <div class="container">            
            <!-- Start Atribute Navigation -->
            <div class="attr-nav">
                <ul>
                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown" >
                            <i class="fa fa-shopping-bag"></i>
                            <img alt="" src="../images/message_1296db.png">
                            <span class="badge">3</span>
                        </a>
                        <ul class="dropdown-menu cart-list">
                            <li>
                                <a href="#" class="photo"><img src="../images/thumb/thumb01.jpg" class="cart-thumb" alt="" /></a>
                                <h6><a href="#">Delica omtantur </a></h6>
                                <p>2x - <span class="price">$99.99</span></p>
                            </li>
                            <li>
                                <a href="#" class="photo"><img src="../images/thumb/thumb02.jpg" class="cart-thumb" alt="" /></a>
                                <h6><a href="#">Omnes ocurreret</a></h6>
                                <p>1x - <span class="price">$33.33</span></p>
                            </li>
                            <li>
                                <a href="#" class="photo"><img src="../images/thumb/thumb03.jpg" class="cart-thumb" alt="" /></a>
                                <h6><a href="#">Agam facilisis</a></h6>
                                <p>2x - <span class="price">$99.99</span></p>
                            </li>
                            <li class="total">
                                <span class="pull-right"><strong>Total</strong>: $0.00</span>
                                <a href="#" class="btn btn-default btn-cart">Cart</a>
                            </li>
                        </ul>
                    </li>
                    <li class="search"><a href="#"><i class="fa fa-search"><img alt="" src="../images/search_black.png"></i></a></li>
                    <li class="side-menu"><a href="#"><i class="fa fa-bars"><img alt="" src="../images/user_1296db.png"></i></a></li>
                </ul>
            </div>
            <!-- End Atribute Navigation -->

            <!-- Start Header Navigation -->
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#navbar-menu">
                    <i class="fa fa-bars"></i>
                </button>
                <a class="navbar-brand" href="#brand"><img src="../images/logo_1296db.png" class="logo" alt=""></a>
            </div>
            <!-- End Header Navigation -->

            <!-- Collect the nav links, forms, and other content for toggling -->
            <div class="collapse navbar-collapse" id="navbar-menu">
                <ul class="nav navbar-nav navbar-right" data-in="fadeInDown" data-out="fadeOutUp">
                    <li><a href="#">Home</a></li>
                    <li><a href="#">About Us</a></li>
                    <li class="dropdown megamenu-fw">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown">Megamenu</a>
                        <ul class="dropdown-menu megamenu-content" role="menu">
                            <li>
                                <div class="row">
                                    <div class="col-menu col-md-3">
                                        <h6 class="title">Title Menu One</h6>
                                        <div class="content">
                                            <ul class="menu-col">
                                                <li><a href="#">Custom Menu</a></li>
                                                <li><a href="#">Custom Menu</a></li>
                                                <li><a href="#">Custom Menu</a></li>
                                                <li><a href="#">Custom Menu</a></li>
                                                <li><a href="#">Custom Menu</a></li>
                                                <li><a href="#">Custom Menu</a></li>
                                            </ul>
                                        </div>
                                    </div><!-- end col-3 -->
                                    <div class="col-menu col-md-3">
                                        <h6 class="title">Title Menu Two</h6>
                                        <div class="content">
                                            <ul class="menu-col">
                                                <li><a href="#">Custom Menu</a></li>
                                                <li><a href="#">Custom Menu</a></li>
                                                <li><a href="#">Custom Menu</a></li>
                                                <li><a href="#">Custom Menu</a></li>
                                                <li><a href="#">Custom Menu</a></li>
                                                <li><a href="#">Custom Menu</a></li>
                                            </ul>
                                        </div>
                                    </div><!-- end col-3 -->
                                    <div class="col-menu col-md-3">
                                        <h6 class="title">Title Menu Three</h6>
                                        <div class="content">
                                            <ul class="menu-col">
                                                <li><a href="#">Custom Menu</a></li>
                                                <li><a href="#">Custom Menu</a></li>
                                                <li><a href="#">Custom Menu</a></li>
                                                <li><a href="#">Custom Menu</a></li>
                                                <li><a href="#">Custom Menu</a></li>
                                                <li><a href="#">Custom Menu</a></li>
                                            </ul>
                                        </div>
                                    </div>    
                                    <div class="col-menu col-md-3">
                                        <h6 class="title">Title Menu Four</h6>
                                        <div class="content">
                                            <ul class="menu-col">
                                                <li><a href="#">Custom Menu</a></li>
                                                <li><a href="#">Custom Menu</a></li>
                                                <li><a href="#">Custom Menu</a></li>
                                                <li><a href="#">Custom Menu</a></li>
                                                <li><a href="#">Custom Menu</a></li>
                                                <li><a href="#">Custom Menu</a></li>
                                            </ul>
                                        </div>
                                    </div><!-- end col-3 -->
                                </div><!-- end row -->
                            </li>
                        </ul>
                    </li>
                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown" >Dropdowns</a>
                        <ul class="dropdown-menu">
                            <li><a href="#">Custom Menu</a></li>
                            <li><a href="#">Custom Menu</a></li>
                            <li class="dropdown">
                                <a href="#" class="dropdown-toggle" data-toggle="dropdown" >Sub Menu</a>
                                <ul class="dropdown-menu">
                                    <li><a href="#">Custom Menu</a></li>
                                    <li><a href="#">Custom Menu</a></li>
                                    <li class="dropdown">
                                        <a href="#" class="dropdown-toggle" data-toggle="dropdown" >Sub Menu</a>
                                        <ul class="dropdown-menu">
                                            <li><a href="#">Custom Menu</a></li>
                                            <li><a href="#">Custom Menu</a></li>
                                            <li><a href="#">Custom Menu</a></li>
                                            <li><a href="#">Custom Menu</a></li>
                                        </ul>
                                    </li>
                                    <li><a href="#">Custom Menu</a></li>
                                </ul>
                            </li>
                            <li><a href="#">Custom Menu</a></li>
                            <li><a href="#">Custom Menu</a></li>
                            <li><a href="#">Custom Menu</a></li>
                            <li><a href="#">Custom Menu</a></li>
                        </ul>
                    </li>
                    <li><a href="#">Portfolio</a></li>
                    <li><a href="#">Contact Us</a></li>
                </ul>
            </div><!-- /.navbar-collapse -->
        </div>   

        <!-- Start Side Menu -->
        <div class="side">
            <a href="#" class="close-side"><i class="fa fa-times"></i></a>
            <div class="widget">
                <h6 class="title">Custom Pages</h6>
                <ul class="link">
                    <li><a href="#">About</a></li>
                    <li><a href="#">Services</a></li>
                    <li><a href="#">Blog</a></li>
                    <li><a href="#">Portfolio</a></li>
                    <li><a href="#">Contact</a></li>
                </ul>
            </div>
            <div class="widget">
                <h6 class="title">Additional Links</h6>
                <ul class="link">
                    <li><a href="#">Retina Homepage</a></li>
                    <li><a href="#">New Page Examples</a></li>
                    <li><a href="#">Parallax Sections</a></li>
                    <li><a href="#">Shortcode Central</a></li>
                    <li><a href="#">Ultimate Font Collection</a></li>
                </ul>
            </div>
        </div>
        <!-- End Side Menu -->
    </nav>
    <!-- End Navigation -->

    <div class="clearfix"></div>
    <!-- Start Demo -->
    <div id="demo" class="section">
        <div class="container">
            <!-- Start Heading -->
            <div class="row">
                <div class="col-md-8 col-md-offset-2">
                    <div class="heading">
                        <h3 class="title">23种Bootstrap导航菜单布局设计jQuery插件</h3>
                        <p>
                            Start your project with bootsnav, and build your best navigation menu. 
                        </p>
                    </div>

                </div>
            </div>
            <!-- End Heading -->
            <!-- Start Menu -->
            <div class="row">
                <div class="col-md-12">
                    <h6>Custom Navigation Menu</h6>
                    <ol class="menu-demo">
                        <li class="col-md-4 col-sm-6">
                            <a href="nav-menu-right.html">Navbar Menu Right</a>
                        </li>
                        <li class="col-md-4 col-sm-6">
                            <a href="nav-menu-center.html">Navbar Menu Center</a>
                        </li>
                        <li class="col-md-4 col-sm-6">
                            <a href="nav-menu-left.html">Navbar Menu Left</a>
                        </li>
                        <li class="col-md-4 col-sm-6">
                            <a href="nav-menu-dropdown.html">Navbar Dropdown</a>
                        </li>
                        <li class="col-md-4 col-sm-6">
                            <a href="nav-megamenu.html">Navbar Megamenu</a>
                        </li>
                        <li class="col-md-4 col-sm-6">
                            <a href="nav-menu-attr.html">Navbar Atributes</a>
                        </li>
                        <li class="col-md-4 col-sm-6">
                            <a href="nav-menu-shop.html">Navbar Shopping Chart</a>
                        </li>
                        <li class="col-md-4 col-sm-6">
                            <a href="nav-menu-search.html">Navbar Search</a>
                        </li>
                        <li class="col-md-4 col-sm-6">
                            <a href="nav-menu-side.html">Navbar Side Menu</a>
                        </li>
                    </ol>
                </div>
            </div>

            <!-- End Menu -->
            <!-- Start Menu -->
            <div class="row margintop30">
                <div class="col-md-12">
                    <h6>Layout Navigation Menu</h6>
                    <ol class="menu-demo">
                        <li class="col-md-4 col-sm-6">
                            <a href="nav-default.html">Navbar Default</a>
                        </li>
                        <li class="col-md-4 col-sm-6">
                            <a href="nav-brand-center.html">Navbar Center</a>
                        </li>
                        <li class="col-md-4 col-sm-6">
                            <a href="nav-brand-center-alt2.html">Navbar Center Alt2</a>
                        </li>
                        <li class="col-md-4 col-sm-6">
                            <a href="nav-mobile-slide.html">Navbar Mobile Slide</a>
                        </li>
                        <li class="col-md-4 col-sm-6">
                            <a href="nav-full.html">Navbar Full</a>
                        </li>
                        <li class="col-md-4 col-sm-6">
                            <a href="nav-sidebar.html">Navbar Sidebar</a>
                        </li>
                        <li class="col-md-4 col-sm-6">
                            <a href="nav-brand-top.html">Navbar Brand Top</a>
                        </li>
                        <li class="col-md-4 col-sm-6">
                            <a href="nav-sticky.html">Navbar Sticky</a>
                        </li>
                        <li class="col-md-4 col-sm-6">
                            <a href="nav-scrollspy.html">Navbar Scrollspy</a>
                        </li>
                        <li class="col-md-4 col-sm-6">
                            <a href="nav-scrollspy-sidebar.html">Navbar Scrollspy Sidebar</a>
                        </li>
                        <li class="col-md-4 col-sm-6">
                            <a href="nav-fixed-alt1.html">Navbar Fixed alt1</a>
                        </li>
                        <li class="col-md-4 col-sm-6">
                            <a href="nav-fixed-alt2.html">Navbar Fixed alt2</a>
                        </li>
                        <li class="col-md-4 col-sm-6">
                            <a href="nav-fixed-alt3.html">Navbar Fixed alt3</a>
                        </li>
                        <li class="col-md-4 col-sm-6">
                            <a href="nav-fixed-alt4.html">Navbar Fixed alt4</a>
                        </li>
                    </ol>
                </div>
            </div>
            <!-- End Menu -->
        </div>
    </div>
    <!-- End Demo -->
	
	<script src="http://libs.useso.com/js/jquery/1.11.0/jquery.min.js" type="text/javascript"></script>
	<script>window.jQuery || document.write('<script src="../js/jquery-1.11.0.min.js"><\/script>')</script>
	<script src="../js/bootstrap.min.js"></script>
	<script src="../js/bootsnav.js"></script>
</body>
<%-- <body>






	<center>
		<s:form action="checkUserByPhoneAction" method="post">
			<tr>
				<td colspan="2" align="center"><s:property
						value="exception.message" /></td>
			</tr>
			<s:textfield name="user.phoneNumber" key="phoneNumber"
				tooltip="Enter your name" required="true"></s:textfield>
			<s:textfield name="user.password" key="password"
				tooltip="Enter your password" required="true"></s:textfield>
			<s:submit value="save" />
			<s:set />
		</s:form>


	</center>

</body> --%>
</html>