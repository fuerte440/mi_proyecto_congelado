package com.example.pokexcell.ui.consultar;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0012\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0014R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0014"}, d2 = {"Lcom/example/pokexcell/ui/consultar/ActividadConsultarCartasDeColeccion;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "adapter", "Lcom/example/pokexcell/ui/adapters/CartaColeccionAdapter;", "cartaDAO", "Lcom/example/pokexcell/data/dao/CartaDAO;", "cartaListaDAO", "Lcom/example/pokexcell/data/dao/CartaListaDAO;", "idColeccion", "", "idUsuario", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "spinner", "Landroid/widget/Spinner;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "app_debug"})
public final class ActividadConsultarCartasDeColeccion extends androidx.appcompat.app.AppCompatActivity {
    private androidx.recyclerview.widget.RecyclerView recyclerView;
    private com.example.pokexcell.ui.adapters.CartaColeccionAdapter adapter;
    private com.example.pokexcell.data.dao.CartaDAO cartaDAO;
    private com.example.pokexcell.data.dao.CartaListaDAO cartaListaDAO;
    private int idColeccion = -1;
    private int idUsuario = -1;
    private android.widget.Spinner spinner;
    
    public ActividadConsultarCartasDeColeccion() {
        super();
    }
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
}