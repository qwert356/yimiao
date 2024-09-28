const base = {
    get() {
        return {
            url : "http://localhost:8080/ssm6hz40/",
            name: "ssm6hz40",
            // 退出到首页链接
            indexUrl: 'http://localhost:8080/ssm6hz40/front/index.html'
        };
    },
    getProjectName(){
        return {
            projectName: "智能疫苗接种助手"
        } 
    }
}
export default base
