package com.example.stocknews.ui;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.Manifest;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.os.StrictMode;
import android.provider.MediaStore;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;

import com.bumptech.glide.Glide;
import com.example.stocknews.App;
import com.example.stocknews.Base.BaseActivity2;
import com.example.stocknews.LoginActivity;
import com.example.stocknews.R;
import com.example.stocknews.Tools.DataUtil;
import com.example.stocknews.Tools.ToastUtil;
import com.example.stocknews.WebViewActivity;
import com.example.stocknews.databinding.ActivitySetUpBinding;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import cn.leancloud.AVFile;
import cn.leancloud.AVObject;
import cn.leancloud.AVUser;
import io.reactivex.Observer;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;

import static com.example.stocknews.App.getContext;

public class SetUpActivity extends BaseActivity2<ActivitySetUpBinding> {
  private static final String TAG = SetUpActivity.class.getSimpleName();
  private final String IMAGE_FILE_NAME = "head.jpg";// 头像文件名称
  private final int REQUESTCODE_PICK = 111; // 相册选图标记
  private final int REQUESTCODE_TAKE = 222; // 相机拍照标记
  private final int REQUESTCODE_PIC = 333; // 裁切标记
  private Uri mUri;
  private final String path = getContext().getFilesDir().getAbsolutePath();

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    StrictMode.VmPolicy.Builder builder =new StrictMode.VmPolicy.Builder();
    StrictMode.setVmPolicy(builder.build());
    builder.detectFileUriExposure();
    setUserHead();
    onClick();
  }


  private void setUserHead() {
    if (App.getHead().equals("0")){
      binding.ivHead.setImageResource(R.mipmap.touxiang);
    }else {
      Glide.with(getContext())
              .load(App.getHead())
              .into(binding.ivHead);
    }
  }

  private void onClick() {
    //点击返回按钮返回
    binding.ivBack.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        finish();
      }
    });
    //点击隐私政策链接进入WebView页面
    binding.yinsi.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        Intent intent = new Intent(SetUpActivity.this, WebViewActivity.class);
        intent.putExtra("content", "<h2 align=\"center\">隐私政策</h2>\n" +
                "\t\t<P>本隐私政策介绍本公司的隐私数据相关政策和惯例，这将涵盖我们如何收集、使用、处理、存储和/或披露那些通过本公司的移动App收集的关于您的个人信息。请你仔细阅读我们的隐私政策。</P>\n" +
                "\t\t<p>一、本公司如何收集您的个人信息</p>\n" +
                "\t\t<p>个人信息是可用于唯一地识别或联系某人的数据。当您使用本公司的移动App，注册用户过程中我们将会收集您的个人信息，如：电子邮件地址、电话号码。为了保护个人隐私，您不应提供除本公司特别要求之外的任何其它信息。</p>\n" +
                "\t\t<p>二、本公司如何使用您的个人信息</p>\n" +
                "\t\t<p>1、通过您的个人信息，向您发送本公司移动App的服务信息。</p>\n" +
                "\t\t<p>2、通过您的个人信息实现密码找回功能。</p>\n" +
                "\t\t<p>3、除本公司发生重组、合并或出售，可将我们收集的一切个人信息转让给相关第三方外，本公司不会向任何无关第三方提供、出售、出租、分享或交易您的个人信息，除非事先得到您的许可，或该第三方和本公司单独或共同为您提供服务，且在该服务结束后，其将被禁止访问包括其以前能够访问的所有这些信息。</p>\n" +
                "\t\t<p>三、个人信息安全</p>\n" +
                "\t\t<p>保证您的个人数据的安全对我们来说至关重要。当您在本公司的移动App中注册输入个人数据时，我们会利用安全套接字层技术(SSL)对这些信息进行加密。\n" +
                "\t\t\n" +
                "\t\t在数据传输和数据保管两个阶段里，我们会通过广为接受的行业标准（如防火墙、加密和数据隐私法律要求）来保护您向我们提交的信息。\n" +
                "\t\t\n" +
                "\t\t然而，没有任何一种互联网传输或电子存储方法是100%安全的。因此，尽管我们通过商业上可接受的方式来保护您的个人信息，但仍无法保证信息的绝对安全。</p>\n" +
                "\t\t<p>四、本公司会将个人信息保存多久</p>\n" +
                "\t\t<p>一般来说，本公司仅保留您的个人信息至履行收集目的所需的期限，同时将遵守适用法律规定的数据保留期限。</p>\n" +
                "\t\t<p>五、法律免责声明</p>\n" +
                "\t\t<p>在法律要求的情况下，以及本公司认为必须披露与您有关的信息来保护本公司的法定权益和/或遵守司法程序、法院指令或适用于本公司的移动App的法律程序时，我们有权透露您的个人信息。\n" +
                "\t\t\n" +
                "\t\t如果本公司确定为了执行本公司的条款和条件或保护我们的经营，披露是合理必须的，则我们可披露与您有关的信息。</p>\n" +
                "\t\t<p>六、本隐私政策的更改</p>\n" +
                "\t\t<p>如果决定更改隐私政策，我们会在本政策中、本公司网站中以及我们认为适当的位置发布这些更改，以便您了解我们如何收集、使用您的个人信息，哪些人可以访问这些信息，以及在什么情况下我们会透露这些信息。\n" +
                "\t\t\n" +
                "\t\t本公司保留随时修改本政策的权利，因此请经常查看。如对本政策作出重大更改，本公司会通过网站通知的形式告知。</p>");
        startActivity(intent);
      }
    });
    //点击退出登录
    binding.rlLoginOut.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        //点击退出登录后清除用户登录信息并返回主页面
        App.setLoginToken(null);
        App.setName(null);
        App.setHead(null);
        App.setUserInfo(null);
        DataUtil.NEWSINFO = false;
        finish();
      }
    });
    //点击头像修改
    binding.llHead.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        if (App.getLoginToken().equals("0")){
          loginOut();
        }else {
          setHead();
        }
      }
    });
    //点击昵称修改
    binding.llNickname.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        if (App.getLoginToken().equals("0")){
          loginOut();
        }else {
          setUserName();
        }
      }
    });
    //密码修改
    binding.llModifyPassword.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        if (App.getLoginToken().equals("0")){
          loginOut();
        }else {
          ToastUtil.showMessage(SetUpActivity.this, "该功能暂未开放！");
        }
      }
    });
    //关于我
    binding.aboutMe.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        startActivity(new Intent(SetUpActivity.this, AboutMeActivity.class));
      }
    });
  }

  private void setHead() {
    //申请权限
    int requestPermission = checkSelfPermission(Manifest.permission.READ_EXTERNAL_STORAGE);
    int requestPermission2 = checkSelfPermission(Manifest.permission.CAMERA);
    if (requestPermission != PackageManager.PERMISSION_GRANTED
            || requestPermission2 != PackageManager.PERMISSION_GRANTED){
      requestPermissions(new String[]{Manifest.permission.READ_EXTERNAL_STORAGE
              ,Manifest.permission.CAMERA}, 1);
    }
    showDialog();
  }

  /**
   * 头像修改弹窗
   */
  private void showDialog() {
    View view = SetUpActivity.this.getLayoutInflater().inflate(R.layout.photo, null);
    Button photo = view.findViewById(R.id.btn_photo);
    Button picture = view.findViewById(R.id.btn_picture);
    Button cancel = view.findViewById(R.id.btn_cancel);
    final Dialog dialog = new Dialog(SetUpActivity.this, R.style.transparentFrameWindowStyle);
    dialog.setContentView(view, new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
    Window window = dialog.getWindow();
    // 设置显示动画
    window.setWindowAnimations(R.style.main_menu_animstyle);
    WindowManager.LayoutParams wl = window.getAttributes();
    wl.x = 0;
    wl.y = SetUpActivity.this.getWindowManager().getDefaultDisplay().getHeight();
    // 以下这两句是为了保证按钮可以水平满屏
    wl.width = ViewGroup.LayoutParams.MATCH_PARENT;
    wl.height = ViewGroup.LayoutParams.WRAP_CONTENT;
    // 设置显示位置
    dialog.onWindowAttributesChanged(wl);
    // 设置点击外围解散
    dialog.setCanceledOnTouchOutside(true);
    dialog.show();
    photo.setOnClickListener(new View.OnClickListener() {

      @Override
      public void onClick(View v) {
        dialog.dismiss();
        Intent takeIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        mUri = Uri.fromFile(new File(Environment.getExternalStorageDirectory(), IMAGE_FILE_NAME));
        // 下面这句指定调用相机拍照后的照片存储的路径
        takeIntent.putExtra(MediaStore.EXTRA_OUTPUT, mUri);
        startActivityForResult(takeIntent, REQUESTCODE_TAKE);
      }
    });
    picture.setOnClickListener(new View.OnClickListener() {

      @Override
      public void onClick(View v) {
        dialog.dismiss();
        Intent pickIntent = new Intent(Intent.ACTION_PICK, null);
        pickIntent.setDataAndType(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, "image/*");
        startActivityForResult(pickIntent, REQUESTCODE_PICK);
      }
    });
    cancel.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        dialog.dismiss();
      }
    });
  }


  /**
   * 修改昵称
   */
  private void setUserName() {
    AlertDialog dialog = new AlertDialog.Builder(this).create();
    dialog.show();
    dialog.setCancelable(false);
    final Window window = dialog.getWindow();
    window.setContentView(R.layout.view_name);
    window.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
    window.setGravity(Gravity.CENTER); //对话框弹出后点击或按返回键不消失;
    //设置属性
    final WindowManager.LayoutParams params = window.getAttributes();
    params.width = WindowManager.LayoutParams.MATCH_PARENT;
    params.flags = WindowManager.LayoutParams.FLAG_DIM_BEHIND;
    params.dimAmount = 0.5f;
    window.setAttributes(params);
    EditText etName = window.findViewById(R.id.et_name);
    ConstraintLayout clSure = window.findViewById(R.id.cl_sure);
    ConstraintLayout clCancel = window.findViewById(R.id.cl_cancel);
    //点击确定更新昵称
    clSure.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        if (etName.getText().toString().trim().equals("")){
          ToastUtil.showMessage(getApplicationContext(), "昵称为空！");
        }else if (!App.getName().equals("0")){
          //判断服务器端有昵称就更新昵称，没有就添加
          new Thread(new Runnable() {
            @Override
            public void run() {
              AVObject todo = AVObject.createWithoutData("UserInfo", App.getUserInfo());
              todo.put("name", etName.getText().toString().trim());
              App.setName(etName.getText().toString().trim());
              todo.save();
            }
          }).start();
          ToastUtil.showMessage(getApplicationContext(), "修改成功！");
          dialog.cancel();
          } else {
            AVObject avObject = new AVObject("UserInfo");
            avObject.put("name", etName.getText().toString().trim());
            avObject.put("user", AVUser.getCurrentUser());
            avObject.saveInBackground().subscribe(new Observer<AVObject>() {
              @Override
              public void onSubscribe(@NonNull Disposable d) {}

              @Override
              public void onNext(@NonNull AVObject avObject) {
                App.setName(etName.getText().toString().trim());
                ToastUtil.showMessage(getApplicationContext(), "昵称添加成功！");
              }
              @Override
              public void onError(@NonNull Throwable e) {
                ToastUtil.showMessage(getApplicationContext(), "修改失败！"+ e.toString());
              }

              @Override
              public void onComplete() {}
            });
            dialog.cancel();
          }
      }
    });

    clCancel.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        dialog.cancel();
      }
    });

  }

  @Override
  protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
    super.onActivityResult(requestCode, resultCode, data);
    switch(requestCode){
      case REQUESTCODE_PICK:
        try {
          if (requestCode == 111){
            cropPhoto(data.getData());
          }
        }catch (NullPointerException e){
          e.printStackTrace();
        }
        break;
      case REQUESTCODE_TAKE:
        if (requestCode == 222){
          File temp = new File(Environment.getExternalStorageDirectory() + "/" + IMAGE_FILE_NAME);
          Log.d(TAG, "查看拍照图片是否成功----》" + temp);
          cropPhoto(Uri.fromFile(temp));
        }
        break;
      case REQUESTCODE_PIC:
        if (data != null){
          Bundle bundle = data.getExtras();
          Bitmap head = bundle.getParcelable("data");
          if (head != null){
            setPicToView(head);
            try {
              setHeadInfo(path);
            } catch (FileNotFoundException e) {
              e.printStackTrace();
            }
          }
        }
      default:
        break;
    }
  }

  /**
   * 图片裁切
   * @param uri
   */
  private void cropPhoto(Uri uri) {
    Intent intent = new Intent("com.android.camera.action.CROP");
    intent.setDataAndType(uri, "image/*");
    intent.putExtra("crop", "true");
// aspectX aspectY 是宽高的比例
    intent.putExtra("aspectX", 1);
    intent.putExtra("aspectY", 1);
// outputX outputY 是裁剪图片宽高
    intent.putExtra("outputX", 150);
    intent.putExtra("outputY", 150);
    intent.putExtra("return-data", true);
    startActivityForResult(intent, REQUESTCODE_PIC);
  }

  /**
   * 保存到本地
   * @param mBitmap
   */
  private void setPicToView(Bitmap mBitmap) {
    String sdStatus = Environment.getExternalStorageState();
    if (!sdStatus.equals(Environment.MEDIA_MOUNTED)) {// 检测sd是否可用
      Log.d(TAG,"SD卡不可用");
      return;
    }
    FileOutputStream b = null;
    File file = new File(path);
    file.mkdirs();// 创建文件夹
    String fileName = path + IMAGE_FILE_NAME;// 图片名字
    Log.d(TAG, "图片名字" + fileName);
    try {
      b = new FileOutputStream(fileName);
      mBitmap.compress(Bitmap.CompressFormat.JPEG, 100, b);// 把数据写入文件
      Log.d(TAG,"文件写入成功");
    } catch (FileNotFoundException e) {
      Log.d(TAG,"文件写入失败！" + e.toString());
      e.printStackTrace();
    } finally {
      try {
        b.flush();
        b.close();
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
  }

  /**
   * 上传到服务器
   * @param path
   */
  private void setHeadInfo(String path) throws FileNotFoundException {
    Log.d(TAG,"this");
    //构建文件对象
    AVFile mFile = AVFile.withAbsoluteLocalPath("head.jpg", path + IMAGE_FILE_NAME);
    //保存头像文件
    mFile.saveInBackground().subscribe(new Observer<AVFile>() {
      @Override
      public void onSubscribe(@NonNull Disposable d) {}

      @Override
      public void onNext(@NonNull AVFile avFile) {
        Log.d(TAG, "文件上传成功-----》" + avFile.getObjectId());
        App.setHead(avFile.getUrl());
        new Thread(new Runnable() {
          @Override
          public void run() {
            AVObject todo = AVObject.createWithoutData("UserInfo", App.getUserInfo());
            todo.put("head", mFile.getUrl());
            todo.save();
          }
        }).start();
      }

      @Override
      public void onError(@NonNull Throwable e) {
        Log.d(TAG, "文件上传失败------->" + e.toString());
      }

      @Override
      public void onComplete() {}
    });
  }

  public void loginOut(){
    Intent intent = new Intent(SetUpActivity.this, LoginActivity.class);
    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
    startActivity(intent);
  }

  @Override
  protected void onPause() {
    super.onPause();
    setUserHead();
  }
}