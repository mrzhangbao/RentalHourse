<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE >
<html>
<head>

<title>Uploader上传控件</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">

<script src="../../js/jquery-3.1.1.js"></script>

<!-- include -->
<script type="text/javascript" src="../../js/webuploader/webuploader.js"></script>
<link rel="stylesheet" type="text/css"
	href="../../js/webuploader/webuploader.css">
	<link rel="stylesheet" type="text/css"
	href="../../js/webuploader/user-avatar-upload.css">
<!-- include -->
<style type="text/css">
.avatar{
height:10%;
width:15%;
}
.placeholder-cus{
 border: 3px dashed #e6e6e6;
    min-height: 20px;
    padding-top: 18px;
    text-align: center;
    color: #cccccc;
    font-size: 16px;
    position: relative;

}

</style>
</head>
<body>

	 
      
            <!--头部，相册选择和格式选择-->
			<div class="avatar">
            <div id="uploader"  >
                <div class="queueList">
                    <div id="dndArea" class="placeholder-cus">
                        <div id="filePicker"></div>
                    </div>
                </div>
               
                <div class="btns">
                       <div class="uploadBtn"><button class="btn btn-primary">开始上传</button></div>
                    </div>
            </div>
  			</div>
 

	 
    <script>
        // 实例化
        var $list=$('.queueList');
        ratio = window.devicePixelRatio || 1,

       
        thumbnailWidth = 100 * ratio,
        thumbnailHeight = 100 * ratio,
        // Web Uploader实例
        uploader;
        var uploader = WebUploader.create({
            pick: {
                id: '#filePicker',
                multiple:false
            },
            formData: {
                uid: 123
            },
            fileNumLimit: 1,
          
            chunked: false,
            chunkSize: 512 * 1024,
            server: 'saveAvatar',//上传的URL
            // runtimeOrder: 'flash',
             accept: {
                 title: 'Images',
                 extensions: 'gif,jpg,jpeg,bmp,png'
             },
            // 禁掉全局的拖拽功能。这样不会出现图片拖进页面的时候，把图片打开。
            disableGlobalDnd: true,
            fileNumLimit: 300,
            fileSizeLimit: 200 * 1024 * 1024,    // 200 M
            fileSingleSizeLimit: 50 * 1024 * 1024    // 50 M
        });
        
        // 当有文件添加进来的时候
        uploader.on( 'fileQueued', function( file ) {
        	
        	for (var i = 0; i < uploader.getFiles().length; i++) {
                
            }
    		
    		
    		
            
            
           
        	
        	if(uploader.getFiles().length>1){
        		alert("here"+uploader.getFiles().length>1);
        		// 将图片从上传序列移除
                uploader.removeFile(uploader.getFiles()[i]);
                //uploader.removeFile(uploader.getFiles()[i], true);
                //delete uploader.getFiles()[i];
                // 将图片从缩略图容器移除
                var $li = $('#' + uploader.getFiles()[i].id);
                $li.off().remove();
                setState('pedding');
             // 重置文件总个数和总大小
                fileCount = 0;
                fileSize = 0;
                // 重置uploader，目前只重置了文件队列
                uploader.reset();
                // 更新状态等，重新计算文件总个数和总大小
                updateStatus(); 
        	}
             alert("size:"+uploader.getFiles().length);
           
        	
            var $li = $(
                    '<div id="' + file.id + '" class="file-item thumbnail">' +
                        '<img>' +
                        '<div class="info">' + file.name + '</div>' +
                    '</div>'
                    ),
                $img = $li.find('img');

            $list.append( $li );

            // 创建缩略图
            uploader.makeThumb( file, function( error, src ) {
                if ( error ) {
                    $img.replaceWith('<span>不能预览</span>');
                    return;
                }

                $img.attr( 'src', src );
            }, thumbnailWidth, thumbnailHeight );
            // 文件上传过程中创建进度条实时显示。
            uploader.on( 'uploadProgress', function( file, percentage ) {
                var $li = $( '#'+file.id ),
                    $percent = $li.find('.progress span');

                // 避免重复创建
                if ( !$percent.length ) {
                    $percent = $('<p class="progress"><span></span></p>')
                            .appendTo( $li )
                            .find('span');
                }

                $percent.css( 'width', percentage * 100 + '%' );
            });

            // 文件上传成功，给item添加成功class, 用样式标记上传成功。
            uploader.on( 'uploadSuccess', function( file ) {
                $( '#'+file.id ).addClass('upload-state-done');
            });

            // 文件上传失败，现实上传出错。
            uploader.on( 'uploadError', function( file ) {
                var $li = $( '#'+file.id ),
                    $error = $li.find('div.error');

                // 避免重复创建
                if ( !$error.length ) {
                    $error = $('<div class="error"></div>').appendTo( $li );
                }

                $error.text('上传失败');
            });

            // 完成上传完了，成功或者失败，先删除进度条。
            uploader.on( 'uploadComplete', function( file ) {
                $( '#'+file.id ).find('.progress').remove();
            });
        });
        
    
   

        
        
        
        /** 附件函数
        uploader.on( 'uploadSuccess', function( type ) {
           alert(11000);
        });
        */
    </script>
   
</body>
</html>