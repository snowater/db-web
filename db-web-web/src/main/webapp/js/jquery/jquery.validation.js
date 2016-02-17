(function($) {
    /*
    Validation Singleton
    */
    var Validation = function() {
        
        var rules = {
            
            email : {
               check: function(value) {
                   
                   if(value)
                       return testPattern(value,"[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])");
                   return true;
               },
               msg : "Email不合法."
            },
            url : {

               check : function(value) {

                   if(value)
                       return testPattern(value,"^https?://(.+\.)+.{2,4}(/.*)?$");
                   return true;
               },
               msg : "URL不合法."
            },
            required : {
                
               check: function(value) {

                   if(value)
                       return true;
                   else
                       return false;
               },
               msg : "必填"
            },
            ip:{
            	check:function(value){
            		return testPattern(value, "^\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}$")
            	},
            	msg :"ip不合法"
            },
            notdefault : {
                check: function(value) {
                    if(value != "-1")
                        return true;
                    else
                        return false;
                },
                msg : "请选择"
             }
        }
        var testPattern = function(value, pattern) {
            var regExp = new RegExp(pattern,"");
            return regExp.test(value);
        }
        return {
            
            addRule : function(name, rule) {

                rules[name] = rule;
            },
            getRule : function(name) {

                return rules[name];
            }
        }
    }
    
    /* 
    Form factory 
    */
    var Form = function(form) {
        
        var fields = [];
    
        form.find("[validation]").each(function() {
            var field = $(this);
            if(field.attr('validation') !== undefined) {
                fields.push(new Field(field));
            }
        });
        this.fields = fields;
    }
    Form.prototype = {
        validate : function() {

            for(field in this.fields) {
                if (this.fields.hasOwnProperty(field)) { // 过滤掉原型链中的属性
                	this.fields[field].validate();
				}
            }
        },
        isValid : function() {
            
            for(field in this.fields) {
                if (this.fields.hasOwnProperty(field)) {
                	if(!this.fields[field].valid) {
                        
                        this.fields[field].field.focus();
                        return false;
                    }
				}
            }
            return true;
        }
    }
    
    /* 
    Field factory 
    */
    var Field = function(field) {

        this.field = field;
        this.valid = false;
        this.attach("change");
    }
    Field.prototype = {
        
        attach : function(event) {
        
            var obj = this;
            if(event == "change") {
                obj.field.bind("change",function() {
                    return obj.validate();
                });
            }
            if(event == "keyup") {
                obj.field.bind("keyup",function(e) {
                    return obj.validate();
                });
            }
        },
        validate : function() {
            
            var obj = this,
                field = obj.field,
                errorClass = "errorlist",
                errorlist = $(document.createElement("ul")).addClass(errorClass),
                types = field.attr("validation").split(" "),
                container = field.parent(),
                errors = []; 
            
            field.next(".errorlist").remove();
            
            for (var i = 0; i < types.length; i++) {
            	var rule = $.Validation.getRule(types[i]);
                if(!rule.check(field.val())) {

                    container.addClass("error");
                    errors.push(rule.msg);
                }
			}
            
            if(errors.length) {

                obj.field.unbind("keyup")
                obj.attach("keyup");
                field.after(errorlist.empty());
                for (var i = 0; i < errors.length; i++) {
                	errorlist.append("<li>"+ errors[i] +"</li>");
				}
                obj.valid = false;
            } 
            else {
                errorlist.remove();
                container.removeClass("error");
                obj.valid = true;
            }
        }
    }
    
    /*
    Validation extends jQuery prototype
    */
    $.extend($.fn, {
        
        validation : function() {
            
            var validator = new Form($(this));
            $.data($(this)[0], 'validator', validator);
            
            $(this).bind("submit", function(e) {
                validator.validate();
                if(!validator.isValid()) {
                    e.preventDefault();
                }
            });
        },
        validate : function() {
            
            var validator = $.data($(this)[0], 'validator');
            validator.validate();
            return validator.isValid();
            
        }
    });
    $.Validation = new Validation();
})(jQuery);