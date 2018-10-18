layui.extend({
    setter: "config", // 配置文件
    admin: "lib/admin",
    view: "lib/view",
}).define(["setter", "admin"], function (exports) {
    var setter = layui.setter,
        element = layui.element,
        admin = layui.admin,
        tabsPage = admin.tabsPage,
        view = layui.view,
        eleLayAppBody = "#LAY_app_body",
        eleLayadminLayoutTabs = "layadmin-layout-tabs",
        $ = layui.$,
        // 链接地址点击事件 处理
        openTabsPage = function (url, title) {
            var alreadyOpen = false // 是否已打开该页面
            // 现有的tab
            var liEleArray = $("#LAY_app_tabsheader>li")
            // 去除 http（s） 以及 query
            // var urlDelHtpp = url.replace(/(^http(s*):)|(\?[\s\S]*$)/g, "")
            var urlDelHtpp = url
            if (liEleArray.each(
                    function (e) {
                        var ele = $(this)
                        var id = ele.attr("lay-id")
                        // 如果 已存在tab
                        if (id === url) {
                            alreadyOpen = true
                            tabsPage.index = e
                        }
                    }),
                    title = title || "新标签页",
                    setter.pageTabs // 是否打开选项卡
            ) {
                if (!alreadyOpen) { // 如果不存在则添加
                    $(eleLayAppBody).append(['<div class="layadmin-tabsbody-item layui-show">', '<iframe src="' + url + '" frameborder="0" class="layadmin-iframe"></iframe>', "</div>"].join("")), tabsPage.index = liEleArray.length,
                        element.tabAdd(eleLayadminLayoutTabs, {
                            title: "<span title=" + title + ">" + title + "</span>",
                            id: url,
                            attr: urlDelHtpp
                        })
                }
            } else { // 无选项卡配置时相关操作
                var iframe = admin.tabsBody(admin.tabsPage.index).find(".layadmin-iframe")
                iframe[0].contentWindow.location.href = url
            }
            element.tabChange(eleLayadminLayoutTabs, url)
            admin.tabsBodyChange(tabsPage.index, {
                url: url,
                text: title
            })
        };
    // 小屏触发自适应方法
    if (admin.screen() < 2) {
        admin.sideFlexible()
    }
    layui.config({
        base: setter.base + "modules/"
    })
    // 遍历 配置文件中的 扩展模块。
    layui.each(setter.extend, function (i, extendName) {
        // 拓展模块别名并配置路径
        var options = {}
        options[extendName] = "{/}" + setter.base + "lib/extend/" + extendName
        layui.extend(options)
    })
    view().autoRender()
    layui.use("common")
    layui.use("admin_nav",function () {
        adminNav=layui.admin_nav;
        adminNav.navMenu('/menu/left', 'layadmin-system-side-menu', false)
    })
    exports("index", {
        openTabsPage: openTabsPage
    })
})