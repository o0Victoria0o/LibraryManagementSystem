package theStuff;
public class PileOfStuff{
    private ThisStuff[] theStuff;
    private int thisStuffCount;

    public PileOfStuff() {
        theStuff = new ThisStuff[200];
        materialCount = 0;
    }

    public boolean addMaterial (Material material) {
        if (thisStuff == null || thisStuffCount == thisStuff.length){
            return false;
        }
        if (findMaterial(material.getMaterialId()) != null) {
            return false;
        }

        materials[materialCount] = material;
        materialCount++;
        return true;
    }

    public Material findMaterial(String materialId){
        for (int i = 0; i<materialCount; 1++){
            if (materials[i].getMaterialId().equals (materialId)){
                return materials[i];
            }
        }

        return null;
    }

    public boolean removeMaterial(String materialId){
        for (int i = 0; i < materialCount; i++) {
            if (materials[i].getMaterialId().equals(materialId)) {
                for (int j = i; j < materialCount - 1; j++) {
                    materials[j] = materials[j+1];
                }
                
                materials[materialCount - 1] = null;
                materialCount--;
                return true;
            }
        }
        return false;
    }
    public Material[] getAllMaterials(){
        Material[] allMaterials = new Material[materialCount];

        for (int i = 0; i < materialCount; i++) {
            allMaterials[i] = materials[i];
        }
        return allMaterials;
    }

    public int getMaterialCount(){
        return materialCount;
    }
}
