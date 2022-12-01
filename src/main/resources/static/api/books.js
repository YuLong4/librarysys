function getBooksList (params) {
  return $axios({
    url: '/books/page',
    method: 'get',
    params
  })
}


// 新增---添加图书
function addBooks (params) {
  return $axios({
    url: '/books',
    method: 'post',
    data: { ...params }
  })
}

// 修改---添加员工
function editBooks (params) {
  return $axios({
    url: '/books',
    method: 'put',
    data: { ...params }
  })
}

// 修改页面反查详情接口
function queryBooksById (isbn) {
  return $axios({
    url: `/books/${isbn}`,
    method: 'get'
  })
}