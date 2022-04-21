import router from './router';
import store from './store';
import NProgress from 'nprogress';
import 'nprogress/nprogress.css';

NProgress.configure({ showSpinner: false })

router.beforeEach(async(to, from, next) => {
    NProgress.start()
    
    document.title = to.meta.title

    if (store.getters.menu && store.getters.menu.length > 0) {
        return next()
    }
    await store.dispatch('user/getInfo')
    router.addRoutes(store.getters.menu)

    //解决刷新空白问题
    return next({...to, replace: true})
})

router.onError(() => {

})

router.afterEach(() => {
    NProgress.done()
})