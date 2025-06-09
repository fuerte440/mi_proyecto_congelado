package com.example.pokexcell.ui.escaneo;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0016\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0017\u001a\u00020\u0010J\u0010\u0010\u0018\u001a\u00020\u00152\u0006\u0010\u0019\u001a\u00020\u0005H\u0002J\u0012\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0014J\b\u0010\u001e\u001a\u00020\u001bH\u0002J\u0010\u0010\u001f\u001a\u00020\u001b2\u0006\u0010 \u001a\u00020\bH\u0002R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0005X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006!"}, d2 = {"Lcom/example/pokexcell/ui/escaneo/EscanearCartaActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "cameraPermissionRequest", "Landroidx/activity/result/ActivityResultLauncher;", "", "cameraProviderFuture", "Lcom/google/common/util/concurrent/ListenableFuture;", "Landroidx/camera/lifecycle/ProcessCameraProvider;", "dbHelper", "Lcom/example/pokexcell/data/db/PokexcelDBHelper;", "detectaCartaRunnable", "Ljava/lang/Runnable;", "handler", "Landroid/os/Handler;", "idLista", "", "previewView", "Landroidx/camera/view/PreviewView;", "textoDetectadoGlobal", "yaProcesado", "", "agregarCartaALaLista", "idCarta", "esNumeroCartaValido", "texto", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "setupCamera", "startCamera", "cameraProvider", "app_release"})
public final class EscanearCartaActivity extends androidx.appcompat.app.AppCompatActivity {
    private androidx.camera.view.PreviewView previewView;
    private com.google.common.util.concurrent.ListenableFuture<androidx.camera.lifecycle.ProcessCameraProvider> cameraProviderFuture;
    private int idLista = -1;
    private com.example.pokexcell.data.db.PokexcelDBHelper dbHelper;
    private boolean yaProcesado = false;
    @org.jetbrains.annotations.NotNull()
    private final android.os.Handler handler = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.Runnable detectaCartaRunnable = null;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String textoDetectadoGlobal = "";
    @org.jetbrains.annotations.NotNull()
    private final androidx.activity.result.ActivityResultLauncher<java.lang.String> cameraPermissionRequest = null;
    
    public EscanearCartaActivity() {
        super();
    }
    
    private final boolean esNumeroCartaValido(java.lang.String texto) {
        return false;
    }
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    private final void setupCamera() {
    }
    
    private final void startCamera(androidx.camera.lifecycle.ProcessCameraProvider cameraProvider) {
    }
    
    public final boolean agregarCartaALaLista(int idLista, int idCarta) {
        return false;
    }
}