import java.util.List;
import java.util.stream.Collectors;

public class Stream {

	// 使用命令式范式实现
	public static String getNamesStringImperatively(List<String> nameList) {
		String str = String.join(",", nameList);
		String outcome = "";
		String[] name = str.split(",");
		for(int i = 0; i < name.length; i++){
			if (name[i].length() != 1){
				String add = name[i].substring(0, 1).toUpperCase() + name[i].substring(1);
				if(outcome.length() != 0){
					outcome = outcome + "," + add;
				}else {
					outcome = outcome + add;
				}
			}
		}
		return outcome;
	}

	// 使用函数式范式实现
	public static String getNamesStringFunctionally(List<String> nameList) {
		return nameList.stream().filter(x -> x.length() > 1)
				.map(x -> x.substring(0, 1).toUpperCase() + x.substring(1))
				.collect(Collectors.joining(","));
	}
}
