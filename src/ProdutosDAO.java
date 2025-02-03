/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Adm
 */

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;


public class ProdutosDAO {
    
    Connection conn;
    PreparedStatement prep;
    ResultSet resultset;
    ArrayList<ProdutosDTO> listagem = new ArrayList<>();
    
    public void cadastrarProduto (ProdutosDTO produto) throws Exception {
        this.conn = new conectaDAO().connectDB();
        this.prep = this.conn.prepareStatement("INSERT INTO produtos (nome, valor, status) VALUES (?,?,?)");
        this.prep.setString(1, produto.getNome());
        this.prep.setInt(2, produto.getValor());
        this.prep.setString(3, produto.getStatus());
        this.prep.execute();
    }
    
    public ArrayList<ProdutosDTO> listarProdutos() throws Exception {
        this.conn = new conectaDAO().connectDB();
        this.prep = this.conn.prepareStatement("SELECT * FROM produtos");
        this.resultset = this.prep.executeQuery();
        
        while (this.resultset.next()) {
            ProdutosDTO produto = new ProdutosDTO();
            produto.setId(this.resultset.getInt("id"));
            produto.setNome(this.resultset.getString("nome"));
            produto.setValor(this.resultset.getInt("valor"));
            produto.setStatus(this.resultset.getString("status"));
            listagem.add(produto);
        }
        
        return listagem;
    }
    
    
    
        
}

