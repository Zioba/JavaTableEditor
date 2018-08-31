package trash;

public class Book {
		private String name;
		private String nameA;
		private String surnameA;
		private String otcA;
		private String firma;
		private int	 numbOfToms;
		private int tir;
		private int itogo;
		
		public Book(String name, String nameA, String surnameA, String otcA,String firma,int numbOfToms,int tir) {
			this.name=name;
			this.nameA=nameA;
			this.surnameA=surnameA;
			this.otcA=otcA;
			this.firma=firma;
			this.numbOfToms=numbOfToms;
			this.tir=tir;
			this.itogo=tir*numbOfToms;
		}
		
		public void setName(String name) {
			this.name = name;
		}
		public String getName() {
			return this.name;
		}
		
		public void setNameA(String nameA) {
			this.nameA = nameA;
		}
		public String getNameA () {
			return this.nameA;
		}
		
		public void setSurnameA(String surnameA) {
			this.surnameA = surnameA;
		}
		public String getSurnameA () {
			return this.surnameA;
		}
		
		public void setOtcA(String otcA) {
			this.otcA = otcA;
		}
		public String getOtcA () {
			return this.otcA;
		}
		
		public void setFirma(String firma) {
			this.firma = firma;
		}
		public String getFirma() {
			return this.firma;
		}
		
		public void setNumbOfToms(int numbOfToms) {
			this.numbOfToms=numbOfToms;
		}
		public int getNumbOfToms() {
			return this.numbOfToms;
		}
		
		public void setTir(int tir) {
			this.tir=tir;
		}
		public int getTir() {
			return this.tir;
		}
		
		public void makeItogo() {
			this.itogo=this.tir*this.numbOfToms;
		}
		public int getItogo() {
			return this.itogo;
		}	
}