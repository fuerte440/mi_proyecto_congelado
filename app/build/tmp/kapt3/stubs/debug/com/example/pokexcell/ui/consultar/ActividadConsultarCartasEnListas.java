package com.example.pokexcell.ui.consultar;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0018\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\r2\u0006\u0010\u001a\u001a\u00020\u0011H\u0002J\b\u0010\u001b\u001a\u00020\u0018H\u0002J\u0010\u0010\u001c\u001a\u00020\u00182\u0006\u0010\u001d\u001a\u00020\u001eH\u0002J\b\u0010\u001f\u001a\u00020\u0018H\u0002J\u0012\u0010 \u001a\u00020\u00182\b\u0010!\u001a\u0004\u0018\u00010\"H\u0015R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082.\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0011X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006#"}, d2 = {"Lcom/example/pokexcell/ui/consultar/ActividadConsultarCartasEnListas;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "adapter", "Lcom/example/pokexcell/ui/adapters/CartaAdapter;", "botonBuscar", "Landroid/widget/Button;", "cartaDAO", "Lcom/example/pokexcell/data/dao/CartaDAO;", "cartaListaDAO", "Lcom/example/pokexcell/data/dao/CartaListaDAO;", "cartasLista", "", "Lcom/example/pokexcell/data/model/CartaConCantidad;", "editBuscarNumero", "Landroid/widget/EditText;", "idColeccion", "", "idLista", "recyclerCartas", "Landroidx/recyclerview/widget/RecyclerView;", "totalCartasTextView", "Landroid/widget/TextView;", "actualizarCantidadEnBD", "", "cartaConCantidad", "nuevaCantidad", "actualizarTotalCartas", "buscarYAgregarCarta", "numeroCarta", "", "cargarCartasDeLista", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "app_debug"})
public final class ActividadConsultarCartasEnListas extends androidx.appcompat.app.AppCompatActivity {
    private android.widget.EditText editBuscarNumero;
    private android.widget.Button botonBuscar;
    private androidx.recyclerview.widget.RecyclerView recyclerCartas;
    private android.widget.TextView totalCartasTextView;
    private com.example.pokexcell.data.dao.CartaDAO cartaDAO;
    private com.example.pokexcell.ui.adapters.CartaAdapter adapter;
    @org.jetbrains.annotations.NotNull()
    private final java.util.List<com.example.pokexcell.data.model.CartaConCantidad> cartasLista = null;
    private com.example.pokexcell.data.dao.CartaListaDAO cartaListaDAO;
    private int idLista = -1;
    private int idColeccion = -1;
    
    public ActividadConsultarCartasEnListas() {
        super();
    }
    
    @java.lang.Override()
    @android.annotation.SuppressLint(value = {"NotifyDataSetChanged", "SetTextI18n"})
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    private final void cargarCartasDeLista() {
    }
    
    private final void buscarYAgregarCarta(java.lang.String numeroCarta) {
    }
    
    private final void actualizarCantidadEnBD(com.example.pokexcell.data.model.CartaConCantidad cartaConCantidad, int nuevaCantidad) {
    }
    
    private final void actualizarTotalCartas() {
    }
}